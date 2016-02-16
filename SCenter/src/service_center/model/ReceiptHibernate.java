package service_center.model;

import java.util.*;

import javax.persistence.*;

import org.springframework.transaction.annotation.Transactional;

import service_center.dao.*;
import service_center.interfaces.IServiceCenter;

public class ReceiptHibernate implements IServiceCenter {
	@PersistenceContext(unitName = "springHibernate")
	EntityManager em;

	///date
	private Date created;
	private Date updated;

	@PrePersist
	private Date onCreate() {
		created = new Date();
		return created;
	}

	//////////asd
	@PreUpdate
	private Date onUpdate() {
		updated = new Date();
		return updated;
	}

	@Override
	@Transactional
	public boolean addReceipt(Receipt receipt) {
		Receipt recEnt = em.find(Receipt.class, receipt.getId());
		if (recEnt == null) {
			recEnt = new Receipt();

			Client client = receipt.getClient();
			Client clientEntity = this.getClient(client.getTelNumber());
			if (clientEntity == null)
				clientEntity = createClient(client);
			recEnt.setClient(clientEntity);

			Product product = receipt.getProduct();
			Product productEnt = this.getProdut(product.getModel(), product.getManufacturer());
			if (productEnt == null)
				productEnt = this.createProduct(product);
			recEnt.setProduct(productEnt);

			Shop shEnt = getShop(receipt.getShop().getName());
			if (shEnt == null) {
				shEnt = new Shop(receipt.getShop().getName(), receipt.getShop().getCode());
				em.persist(shEnt);
			}
			recEnt.setShop(shEnt);

			User user = receipt.getUser();
			User userEnt = this.getUser(user.getTelNumber());
			if (userEnt == null)
				userEnt = this.createUser(user);
			recEnt.setUser(userEnt);

			recEnt.setRepiatRepair(receipt.getRepiatRepair());
			recEnt.setStatus(receipt.getStatus());

			recEnt.setDate(this.onCreate());
			recEnt.setAuthorizedService(receipt.getAuthorizedService());
			recEnt.setDefectClient(receipt.getDefectClient());
			recEnt.setView(receipt.getView());
			recEnt.setEquipment(receipt.getEquipment());
			recEnt.setDefectCorrect(receipt.getDefectCorrect());
			recEnt.setAuthorizedService(receipt.getAuthorizedService());
			em.persist(recEnt);

			addHistory(recEnt);
			return true;
		}
		return false;
	}

	// we are watching you
	@Transactional
	private void addHistory(Receipt recEnt) {
		History historyEntity = new History();
		historyEntity.setReceipt(recEnt);
		historyEntity.setDate(recEnt.getDate());
		historyEntity.setStatus(recEnt.getStatus());
		historyEntity.setUser(recEnt.getUser());
		em.persist(historyEntity);
	}

	/* ADD CLIENT */
	@Override
	@Transactional
	public boolean addClient(Client client) {
		Client clientEntity = this.getClient(client.getTelNumber());
		if (clientEntity == null) {
			createClient(client);
			return true;
		}
		return false;
	}

	private Client createClient(Client client) {
		Client clientEntity;
		clientEntity = new Client(client.getfName(), client.getsName(), client.getTelNumber(), client.getEmail(),
				client.getAddress());
		em.persist(clientEntity);
		return clientEntity;
	}

	private Client getClient(String telNumber) {
		Query query = em.createQuery("SELECT u FROM Client u WHERE u.telNumber = ?1");
		query.setParameter(1, telNumber);
		List<Client> res = query.getResultList();
		if (res == null || res.size() == 0)
			return null;
		return res.get(0);
	}

	/* ADD SHOP */
	@Override
	@Transactional
	public boolean addShop(Shop shop) {
		Shop shopEntity = this.getShop(shop.getName());
		if (shopEntity == null) {
			shopEntity = new Shop(shop.getName(), shop.getCode());
			em.persist(shop);
		}
		return true;
	}

	private Shop getShop(String name) {
		Query query = em.createQuery("SELECT s FROM Shop s WHERE s.name= ?1");
		query.setParameter(1, name);
		List<Shop> res = query.getResultList();
		if (res == null || res.size() == 0)
			return null;
		return res.get(0);
	}

	/* ADD USER */
	@Override
	@Transactional
	public boolean addUser(User user) {
		User userEntity = getUser(user.getTelNumber());
		if (userEntity == null) {
			createUser(user);
			return true;
		}
		return false;
	}

	private User createUser(User user) {
		User userEntity;
		userEntity = new User(user.getLogin(), user.getPassword(), user.getfName(), user.getsName(),
				user.getTelNumber());
		Position pos = this.getPosition(user.getPosition().getAccessLevel());
		userEntity.setPosition(pos);
		em.persist(userEntity);
		return userEntity;
	}

	private User getUser(String telNumber) {
		Query query = em.createQuery("SELECT u FROM User u WHERE u.telNumber = ?1");
		query.setParameter(1, telNumber);
		List<User> res = query.getResultList();
		if (res == null || res.size() == 0)
			return null;
		return res.get(0);
	}

	/* ADD POSITION */
	@Override
	@Transactional
	public boolean addPosition(Position position) {
		Position positionEntity = getPosition(position.getPositionJob());
		if (positionEntity == null) {
			positionEntity = new Position(position.getAccessLevel(), position.getPositionJob());
			em.persist(positionEntity);
			return true;
		}
		return false;
	}

	private Position getPosition(String positionJob) {
		Query query = em.createQuery("SELECT p FROM Position p WHERE p.positionJob = ?1");
		query.setParameter(1, positionJob);
		List<Position> res = query.getResultList();
		if (res == null || res.size() == 0)
			return null;
		return res.get(0);
	}

	/* ADD PRODUCT */
	@Override
	@Transactional
	public boolean addProduct(Product product) {
		Product productEntity = getProdut(product.getModel(), product.getManufacturer());
		if (productEntity == null) {
			createProduct(product);
			return true;
		}
		return false;
	}

	private Product createProduct(Product product) {
		Product productEntity;
		ComplexityRepair compEnt = this.getComplRep(product.getComplexityRepair().getComplexity());
		if (compEnt == null) {
			compEnt = this.createComplRep(product.getComplexityRepair());
		}
		productEntity = new Product(product.getName(), product.getSerialNumber(), product.getWarranty(),
				product.getManufacturer(), product.getModel());
		productEntity.setComplexityRepair(compEnt);
		em.persist(productEntity);
		return productEntity;
	}

	private Product getProdut(String model, String manufacturer) {
		Query query = em.createQuery("SELECT p FROM Product p WHERE p.model = ?1 AND p.manufacturer = ?2");
		query.setParameter(1, model);
		query.setParameter(2, manufacturer);
		List<Product> res = query.getResultList();
		if (res == null || res.size() == 0)
			return null;
		return res.get(0);
	}

	/* ADD COMPLEXITY REPAIR */
	@Override
	@Transactional
	public boolean addComplexityRepair(ComplexityRepair complexityRepair) {
		ComplexityRepair complRepEntity = getComplRep(complexityRepair.getComplexity());
		if (complRepEntity == null) {
			createComplRep(complexityRepair);
			return true;
		}
		return false;
	}

	private ComplexityRepair createComplRep(ComplexityRepair complexityRepair) {
		ComplexityRepair complRepEntity;
		complRepEntity = new ComplexityRepair(complexityRepair.getComplexity(), complexityRepair.getTime());
		em.persist(complRepEntity);
		return complRepEntity;
	}

	private ComplexityRepair getComplRep(String complexity) {
		Query query = em.createQuery("SELECT c FROM ComplexityRepair c WHERE c.complexity = ?1");
		query.setParameter(1, complexity);
		List<ComplexityRepair> res = query.getResultList();
		if (res == null || res.size() == 0)
			return null;
		return res.get(0);
	}

	/* ADD STATUS */
	@Override
	@Transactional
	public boolean addStatus(Status status) {
		if (status.getStatus().size() == getStatusSize())
			return false;

		Status statusEntity = em.find(Status.class, status.getId());
		if (statusEntity == null) {
			statusEntity = new Status(status.getStatus());
			em.persist(statusEntity);
			return true;
		}
		return false;
	}

	private int getStatusSize() {
		Query query = em.createQuery("SELECT s FROM Status s");
		List<Status> res = query.getResultList();
		if (res == null || res.size() == 0)
			return 0;
		return res.get(res.size() - 1).getStatus().size();
	}

	/* ADD REPEAT REPAIR */
	@Override
	@Transactional
	public boolean addRepiatRepair(RepiatRepair repiatRepair) {
		RepiatRepair repEntity = em.find(RepiatRepair.class, repiatRepair.getId());
		if (repEntity == null) {
			repEntity = new RepiatRepair();
			repEntity.setAuthorizedService(repiatRepair.getAuthorizedService());
			repEntity.setDefectCorrect(repiatRepair.getDefectCorrect());

			Product product = repiatRepair.getProduct();
			Product productEnt = this.getProdut(product.getModel(), product.getManufacturer());
			repEntity.setProduct(productEnt);

			Receipt rec = em.find(Receipt.class, repiatRepair.getReceipt().getId());
			repEntity.setReceipt(rec);

			User user = this.getUser(repiatRepair.getUser().getTelNumber());
			repEntity.setUser(user);

			repEntity.setStatus(repiatRepair.getStatus());
			repEntity.setDate(this.onCreate());
			repEntity.setDateTransfer(this.onUpdate());
			repEntity.setInfoTransfer(repiatRepair.getInfoTransfer());
			em.merge(repEntity);

			this.addHistory(repEntity);
			return true;
		}
		return false;
	}

	@Transactional
	private void addHistory(RepiatRepair repEntity) {
		History historyEntity = new History();
		historyEntity.setReceipt(repEntity.getReceipt());
		historyEntity.setDate(repEntity.getDate());
		historyEntity.setStatus(repEntity.getStatus());
		historyEntity.setUser(repEntity.getUser());
		em.persist(historyEntity);
	}

	@Override
	public Iterable<Receipt> getAllReceipt() {
		Query query = em.createQuery("SELECT r FROM Receipt r");
		return query.getResultList();
	}

	@Override
	@Transactional
	public boolean updateReceipt(Receipt receipt) {
		Receipt receiptEntityUpdate = em.find(Receipt.class, receipt.getId());
		if (receiptEntityUpdate == null)
			return false;
		receiptEntityUpdate.setUser(receipt.getUser());
		receiptEntityUpdate.setStatus(receipt.getStatus());
		receiptEntityUpdate.setDate(this.onCreate());
		receiptEntityUpdate.setDefectCorrect(receipt.getDefectCorrect());
		receiptEntityUpdate.setAuthorizedService(receipt.getAuthorizedService());
		receiptEntityUpdate.setDateTransfer(receipt.getDateTransfer());
		receiptEntityUpdate.setInfoTransfer(receipt.getInfoTransfer());
		receiptEntityUpdate.setRepiatRepair(receipt.getRepiatRepair());

		em.persist(receiptEntityUpdate);
		this.addHistory(receiptEntityUpdate);
		return false;
	}

	@Override
	public boolean updateProduct(Product product) {
		return false;
	}

	// for generator

	@Override
	public Receipt getReceiptById(int id) {
		return em.find(Receipt.class, id);
	}

	@Override
	public Position getPosition(int id) {
		return em.find(Position.class, id);
	}

	@Override
	public ComplexityRepair getComplexityRepair(int id) {
		return em.find(ComplexityRepair.class, id);
	}

	@Override
	public User getUser(int id) {
		return em.find(User.class, id);
	}

	@Override
	public String getStatus(int id) {
		Query query = em.createQuery("SELECT st FROM Status st");
		List<Status> res = query.getResultList();
		int size = res.size();
		if (res == null || size == 0)
			return null;
		return (String) res.get(size - 1).getStatus().toArray()[id];
	}

	@Override
	public Product getProduct(int id) {
		return em.find(Product.class, id);
	}

	@Override
	public Shop getShop(int id) {
		return em.find(Shop.class, id);
	}

	@Override
	public Client getClient(int id) {
		return em.find(Client.class, id);
	}

}
