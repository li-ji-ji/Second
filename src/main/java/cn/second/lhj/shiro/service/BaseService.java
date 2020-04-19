package cn.second.lhj.shiro.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService <T,ID extends Serializable>{

	public List<T> getAll() throws Exception;
	public T getById(ID id) throws Exception;
	public int add (T t) throws Exception;
	public int update(T t) throws Exception;
	public int delete(ID id) throws Exception;
	
}
