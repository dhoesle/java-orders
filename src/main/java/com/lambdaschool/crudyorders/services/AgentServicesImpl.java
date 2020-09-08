package com.lambdaschool.crudyorders.services;

import com.lambdaschool.crudyorders.models.Agent;
import com.lambdaschool.crudyorders.repositories.AgentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "agentServices")
public class AgentServicesImpl implements AgentServices
{
    @Autowired
    AgentsRepository agentrepos;

    @Override
    public Agent save(Agent agent) {
        return agentrepos.save(agent);
    }
}
