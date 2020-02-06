package com.revature.repository;

import com.revature.model.Trainer;

public interface TrainerRepository {
	public int save(Trainer trainer);
	public Trainer findByName(String name);
	public void update(Trainer trainer);
}
