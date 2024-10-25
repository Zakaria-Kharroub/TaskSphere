package org.example.service;

import org.example.domaine.Request;
import org.example.repository.RequestRepository;

import java.util.List;

public class RequestService {

    private RequestRepository requestRepository;

    public RequestService() {
        this.requestRepository = new RequestRepository();
    }

    public List<Request> getAllRequests() {
        return requestRepository.getAll();
    }
    public Request findRequestById(Long id) {
        return requestRepository.findById(id);
    }
    public void saveRequest(Request request) {
        requestRepository.save(request);
    }
    public void deleteRequest(Long id) {
        requestRepository.delete(id);
    }
    public void updateRequest(Request request) {
        requestRepository.update(request);
    }
}
