package com.wf.loan.service;

import com.wf.loan.dao.EmployeeIssueDetailsDao;
import com.wf.loan.dao.ItemDAO;
import com.wf.loan.model.EmployeeIssueDetails;
import com.wf.loan.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    EmployeeIssueDetailsDao dao;

    @Autowired
    ItemDAO ldao;

    @Override
    public List<Map<String, String>> viewItem(String employee_id) {
        List<EmployeeIssueDetails> issues=dao.findIssueByEmployeeId(employee_id);
        List<Map<String,String>> result=new ArrayList<>();
        for(EmployeeIssueDetails issue: issues){
            Map<String,String> itemMap=new HashMap<String,String>();
            itemMap.put("issue id",issue.getIssue_id()+"");
            Item item=ldao.findItemByItemId(issue.getItem_id()+"");
            itemMap.put("item description",item.getItem_description());
            itemMap.put("item make",item.getItem_make()+"");
            itemMap.put("item category",item.getItem_category()+"");
            itemMap.put("item valuation",item.getItem_valuation()+"");
            result.add(itemMap);
        }
        return result;
    }
}
