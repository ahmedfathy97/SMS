package com.sms.service;



import com.sms.model.lookUp.QuestionType;
import com.sms.repository.LookupRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class LookUpSer {
  private LookupRep lookupRep ;
    @Autowired
    public LookUpSer(LookupRep lookupRep) {
        this.lookupRep = lookupRep;
    }


    public List<QuestionType> getAllQuestionsTypes()
    {
       List<QuestionType> questionTypeList =this.lookupRep.getAllQuestionType() ;
       return questionTypeList ;
    }
}
