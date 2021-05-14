package com.example.lab1.controller;

import com.example.lab1.service.LoanService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@RestController
public class LoanController {
    private final LoanService loanService;
    Logger logger=Logger.getLogger(LoanController.class.getName());

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    //
    @GetMapping("/autoRepay")
    @ApiOperation("自动归还贷款")
    public ResponseEntity<?> autoRepay(){
        HashMap<String,String> res=new HashMap<>();
        res.put("message",loanService.autoRepay());
        return ResponseEntity.ok(res);
    }

    /**
     * 通过身份证号查询客户信息
     * @param idNumber
     * @return
     */
    @ApiOperation("通过身份证号查询客户信息")
    @GetMapping("/loan/customerInfo")
    public ResponseEntity<?> findCustomerByIdNumber(@RequestParam String idNumber){
        return ResponseEntity.ok(loanService.findCustomerByIdNumber(idNumber));
    }

    /**
     * 通过客户号查询客户自己的所有贷款
     * @param customerCode
     * @return
     */
    @GetMapping("/loan/customerLoans")
    @ApiOperation("通过客户号查询客户自己的所有贷款")
    public ResponseEntity<?> findLoansByCustomerCode(@RequestParam("code") String customerCode){
        logger.info("传入的code为"+customerCode);
        return ResponseEntity.ok(loanService.findLoansByCustomerCode(customerCode));
    }


    /**
     * 通过借据号查询该贷款的所有分期计划
     * @param iouNum
     * @return
     */
    @GetMapping("/loan/repayPlans")
    @ApiOperation("通过借据号查询该贷款的所有分期计划")
    public ResponseEntity<?> findRepayPlansByIouNum(@RequestParam String iouNum){

        return ResponseEntity.ok(loanService.findRepayPlansByIouNum(iouNum));
    }

    /**
     * 通过还款计划的id查看某贷款的具体一期还款计划
     * @param id
     * @return
     */
    @GetMapping("/loan/repayPlanDetail")
    @ApiOperation("通过还款计划的id查看某贷款的具体一期还款计划")
    public ResponseEntity<?> findRepayPlanById(@RequestParam int id){
        return ResponseEntity.ok(loanService.findRepayPlanById(id));
    }

    /**
     * 通过借据号找到旗下所有未还的还款计划
     * @param iouNum
     * @return
     */
    @GetMapping("/loan/unPayPlans")
    @ApiOperation("通过借据号找到旗下所有未还的还款计划")
    public ResponseEntity<?> findUnPayPlans(@RequestParam String iouNum){
        return ResponseEntity.ok(loanService.findUnPayPlans(iouNum));
    }

    /**
     * 通过借据号归还罚金
     * @param params
     * @return
     */
    @PostMapping("/loan/fine")
    @ApiOperation("通过借据号归还罚金")
    public ResponseEntity<?> repayFine(@RequestBody Map<String,String> params){
        String iouNum=params.get("iouNum");
        HashMap<String,String> res=new HashMap<>();
        logger.info("归还罚金 iouNum is "+iouNum);
        res.put("message",loanService.repayFine(iouNum));
        return ResponseEntity.ok(res);
    }

    /**
     * 在已归还罚金的前提下,通过借据号和还款金额来部分还款
     * @param params
     * @return
     */
    @PostMapping("/loan/repay/part")
    @ApiOperation("在已归还罚金的前提下,通过借据号和还款金额来部分还款")
    public ResponseEntity<?> repayPart(@RequestBody Map<String,String> params){
        String iouNum=params.get("iouNum");
        double repayAmount=Double.parseDouble(params.get("repayAmount"));
        return ResponseEntity.ok(loanService.repayPart(iouNum,repayAmount));
    }

    /**
     * 在已归还罚金的前提下，归还全款
     * @param params
     * @return
     */
    @PostMapping("/loan/repay/all")
    @ApiOperation("在已归还罚金的前提下，归还全款")
    public  ResponseEntity<?> repayAll(@RequestBody Map<String,String> params){
        String iouNum=params.get("iouNum");

        return ResponseEntity.ok(loanService.repayAll(iouNum));
    }

    /**
     * 通过银行卡号来归还该卡欠的所有罚金
     * @param accountNum
     * @return
     */
    @ApiOperation("通过银行卡号来归还该卡欠的所有罚金")
    @GetMapping("/loan/payFineOfCard")
    public ResponseEntity<?> payFineOfCard(@RequestParam String accountNum){
        HashMap<String,String> res=new HashMap<>();
        if (loanService.payFineOfCard(accountNum)){
            res.put("message","success");
        }else{
            res.put("message","fail");
        }
        return ResponseEntity.ok(res);
    }



}
