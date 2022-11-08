package com.wf.loan.service;

import java.util.List;
import java.util.Map;

public interface ItemService {
    List<Map<String,String>> viewItem(String employee_id);
}
