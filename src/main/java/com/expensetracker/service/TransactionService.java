package com.expensetracker.service;


import com.expensetracker.entity.TransactionEnt;
import org.springframework.web.bind.annotation.RequestBody;

import javax.websocket.server.PathParam;


public interface TransactionService {



 TransactionEnt saveTransaction(@RequestBody TransactionEnt transaction,
                                @PathParam(value = "username") String username);
}
