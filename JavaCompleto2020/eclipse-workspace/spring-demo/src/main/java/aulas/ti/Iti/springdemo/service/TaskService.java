package aulas.ti.Iti.springdemo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import aulas.ti.Iti.springdemo.bean.Status;
import aulas.ti.Iti.springdemo.bean.TaskBean;

@Component
public class TaskService {

	private static List<TaskBean> tasks = new ArrayList<>();
	static {
		TaskBean t1 = new TaskBean(1, "Tarefa 1", "não terminada");
		TaskBean t2 = new TaskBean(2, "Tarefa 2", "não terminada");
		TaskBean t3 = new TaskBean(3, "Tarefa 3", "não terminada");
		TaskBean t4 = new TaskBean(4, "Tarefa 4", "não terminada");
		tasks.add(t1);
		tasks.add(t2);
		tasks.add(t3);
		tasks.add(t4);
	}
	
	public TaskBean getTaskById(int id) {
		for(TaskBean tb : tasks) {
			if (tb.getId() == id) {
				return tb;
			}
		}
		return null;
	}
	
	public List<TaskBean> getAllTasks(){
		return tasks;
	}
	
	public Status deleteTaskById(int id) {
		Iterator<TaskBean> it = tasks.iterator();
		while (it.hasNext()) {
			TaskBean tb = it.next();
			if(tb.getId() == id) {
				it.remove();
				return Status.SUCCESS;
			}
		}
		return Status.FAILURE;
	}
	
	//getTaskById(int)
	//getAllTasks()
	//deleteTaskById()
}
