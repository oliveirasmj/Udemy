package aulas.ti.Iti.springdemo.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import aulas.ti.Iti.springdemo.bean.Status;
import aulas.ti.Iti.springdemo.bean.TaskBean;
import aulas.ti.Iti.springdemo.service.TaskService;
import springdemo.iti.ti.aulas.tasks.DeleteTaskRequest;
import springdemo.iti.ti.aulas.tasks.DeleteTaskResponse;
import springdemo.iti.ti.aulas.tasks.GetAllTaskRequest;
import springdemo.iti.ti.aulas.tasks.GetAllTaskResponse;
import springdemo.iti.ti.aulas.tasks.GetTaskRequest;
import springdemo.iti.ti.aulas.tasks.GetTaskResponse;
import springdemo.iti.ti.aulas.tasks.Task;
import springdemo.iti.ti.aulas.tasks.Tstatus;

@Endpoint
public class TaskEndpoint {

	private static final String NAMESPACE_URI = "http://aulas.ti.Iti.springdemo/tasks";
	
	@Autowired
	private TaskService taskService;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getTaskRequest")
	@ResponsePayload
	public GetTaskResponse procesTaskRequest(@RequestPayload GetTaskRequest request) {
		GetTaskResponse response = new GetTaskResponse();
		TaskBean tb = taskService.getTaskById(request.getId());
		Task t = new Task();
		t.setId(tb.getId());
		t.setName(tb.getName());
		t.setStatus(tb.getStatus());
		
		response.setTask(t);
		
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllTaskRequest")
	@ResponsePayload
	public GetAllTaskResponse procesTaskRequest(@RequestPayload GetAllTaskRequest request) {
		GetAllTaskResponse response = new GetAllTaskResponse();
		List<TaskBean> tasks = taskService.getAllTasks();
		for(TaskBean tb : tasks) {
			Task t = new Task();
			t.setId(tb.getId());
			t.setName(tb.getName());
			t.setStatus(tb.getStatus());			
			response.getTask().add(t);
		}
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteTaskRequest")
	@ResponsePayload
	public DeleteTaskResponse procesTaskRequest(@RequestPayload DeleteTaskRequest request) {
		DeleteTaskResponse response = new DeleteTaskResponse();
		Status status = taskService.deleteTaskById(request.getId());
		response.setStatus((Tstatus.FAILURE));
		if(status == Status.SUCCESS) {
			response.setStatus(Tstatus.SUCCESS);
		}
		return response;
	}
}
