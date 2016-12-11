package models;

import service.CategoryService;

public class Category implements RuleSet {
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	@Override
	public void applyRules() throws RuleException {
		if(RuleSetFactory.isEmpty(name)){
			throw new RuleException("Category cannot be empty");
		}

		if(!new CategoryService().isUniqueCategory(name)){
			throw new RuleException("The category already exists");


		}

	}
}
