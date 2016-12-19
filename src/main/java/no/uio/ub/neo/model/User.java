package no.uio.ub.neo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USERS_USERID_GENERATOR", sequenceName="USERS_USER_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USERS_USERID_GENERATOR")
	@Column(name="user_id")
	private Integer userId;

	private Timestamp created;

	private String domain;

	private String name;

	private String username;

	//bi-directional many-to-one association to Concept
	@OneToMany(mappedBy="user1")
	private List<Concept> concepts1;

	//bi-directional many-to-one association to Concept
	@OneToMany(mappedBy="user2")
	private List<Concept> concepts2;

	//bi-directional many-to-one association to Concept
	@OneToMany(mappedBy="user3")
	private List<Concept> concepts3;

	//bi-directional many-to-one association to Mapping
	@OneToMany(mappedBy="user1")
	private List<Mapping> mappings1;

	//bi-directional many-to-one association to Mapping
	@OneToMany(mappedBy="user2")
	private List<Mapping> mappings2;

	//bi-directional many-to-one association to Relationship
	@OneToMany(mappedBy="user1")
	private List<Relationship> relationships1;

	//bi-directional many-to-one association to Relationship
	@OneToMany(mappedBy="user2")
	private List<Relationship> relationships2;

	//bi-directional many-to-one association to String
	@OneToMany(mappedBy="user1")
	private List<String> strings1;

	//bi-directional many-to-one association to String
	@OneToMany(mappedBy="user2")
	private List<String> strings2;

	//bi-directional many-to-one association to String
	@OneToMany(mappedBy="user3")
	private List<String> strings3;

	//bi-directional many-to-one association to Term
	@OneToMany(mappedBy="user1")
	private List<Term> terms1;

	//bi-directional many-to-one association to Term
	@OneToMany(mappedBy="user2")
	private List<Term> terms2;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="created_by")
	private User user;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="user")
	private List<User> users;

	public User() {
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public String getDomain() {
		return this.domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Concept> getConcepts1() {
		return this.concepts1;
	}

	public void setConcepts1(List<Concept> concepts1) {
		this.concepts1 = concepts1;
	}

	public Concept addConcepts1(Concept concepts1) {
		getConcepts1().add(concepts1);
		concepts1.setUser1(this);

		return concepts1;
	}

	public Concept removeConcepts1(Concept concepts1) {
		getConcepts1().remove(concepts1);
		concepts1.setUser1(null);

		return concepts1;
	}

	public List<Concept> getConcepts2() {
		return this.concepts2;
	}

	public void setConcepts2(List<Concept> concepts2) {
		this.concepts2 = concepts2;
	}

	public Concept addConcepts2(Concept concepts2) {
		getConcepts2().add(concepts2);
		concepts2.setUser2(this);

		return concepts2;
	}

	public Concept removeConcepts2(Concept concepts2) {
		getConcepts2().remove(concepts2);
		concepts2.setUser2(null);

		return concepts2;
	}

	public List<Concept> getConcepts3() {
		return this.concepts3;
	}

	public void setConcepts3(List<Concept> concepts3) {
		this.concepts3 = concepts3;
	}

	public Concept addConcepts3(Concept concepts3) {
		getConcepts3().add(concepts3);
		concepts3.setUser3(this);

		return concepts3;
	}

	public Concept removeConcepts3(Concept concepts3) {
		getConcepts3().remove(concepts3);
		concepts3.setUser3(null);

		return concepts3;
	}

	public List<Mapping> getMappings1() {
		return this.mappings1;
	}

	public void setMappings1(List<Mapping> mappings1) {
		this.mappings1 = mappings1;
	}

	public Mapping addMappings1(Mapping mappings1) {
		getMappings1().add(mappings1);
		mappings1.setUser1(this);

		return mappings1;
	}

	public Mapping removeMappings1(Mapping mappings1) {
		getMappings1().remove(mappings1);
		mappings1.setUser1(null);

		return mappings1;
	}

	public List<Mapping> getMappings2() {
		return this.mappings2;
	}

	public void setMappings2(List<Mapping> mappings2) {
		this.mappings2 = mappings2;
	}

	public Mapping addMappings2(Mapping mappings2) {
		getMappings2().add(mappings2);
		mappings2.setUser2(this);

		return mappings2;
	}

	public Mapping removeMappings2(Mapping mappings2) {
		getMappings2().remove(mappings2);
		mappings2.setUser2(null);

		return mappings2;
	}

	public List<Relationship> getRelationships1() {
		return this.relationships1;
	}

	public void setRelationships1(List<Relationship> relationships1) {
		this.relationships1 = relationships1;
	}

	public Relationship addRelationships1(Relationship relationships1) {
		getRelationships1().add(relationships1);
		relationships1.setUser1(this);

		return relationships1;
	}

	public Relationship removeRelationships1(Relationship relationships1) {
		getRelationships1().remove(relationships1);
		relationships1.setUser1(null);

		return relationships1;
	}

	public List<Relationship> getRelationships2() {
		return this.relationships2;
	}

	public void setRelationships2(List<Relationship> relationships2) {
		this.relationships2 = relationships2;
	}

	public Relationship addRelationships2(Relationship relationships2) {
		getRelationships2().add(relationships2);
		relationships2.setUser2(this);

		return relationships2;
	}

	public Relationship removeRelationships2(Relationship relationships2) {
		getRelationships2().remove(relationships2);
		relationships2.setUser2(null);

		return relationships2;
	}

	public List<String> getStrings1() {
		return this.strings1;
	}

	public void setStrings1(List<String> strings1) {
		this.strings1 = strings1;
	}

	public String addStrings1(String strings1) {
		getStrings1().add(strings1);
		strings1.setUser1(this);

		return strings1;
	}

	public String removeStrings1(String strings1) {
		getStrings1().remove(strings1);
		strings1.setUser1(null);

		return strings1;
	}

	public List<String> getStrings2() {
		return this.strings2;
	}

	public void setStrings2(List<String> strings2) {
		this.strings2 = strings2;
	}

	public String addStrings2(String strings2) {
		getStrings2().add(strings2);
		strings2.setUser2(this);

		return strings2;
	}

	public String removeStrings2(String strings2) {
		getStrings2().remove(strings2);
		strings2.setUser2(null);

		return strings2;
	}

	public List<String> getStrings3() {
		return this.strings3;
	}

	public void setStrings3(List<String> strings3) {
		this.strings3 = strings3;
	}

	public String addStrings3(String strings3) {
		getStrings3().add(strings3);
		strings3.setUser3(this);

		return strings3;
	}

	public String removeStrings3(String strings3) {
		getStrings3().remove(strings3);
		strings3.setUser3(null);

		return strings3;
	}

	public List<Term> getTerms1() {
		return this.terms1;
	}

	public void setTerms1(List<Term> terms1) {
		this.terms1 = terms1;
	}

	public Term addTerms1(Term terms1) {
		getTerms1().add(terms1);
		terms1.setUser1(this);

		return terms1;
	}

	public Term removeTerms1(Term terms1) {
		getTerms1().remove(terms1);
		terms1.setUser1(null);

		return terms1;
	}

	public List<Term> getTerms2() {
		return this.terms2;
	}

	public void setTerms2(List<Term> terms2) {
		this.terms2 = terms2;
	}

	public Term addTerms2(Term terms2) {
		getTerms2().add(terms2);
		terms2.setUser2(this);

		return terms2;
	}

	public Term removeTerms2(Term terms2) {
		getTerms2().remove(terms2);
		terms2.setUser2(null);

		return terms2;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setUser(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setUser(null);

		return user;
	}

}