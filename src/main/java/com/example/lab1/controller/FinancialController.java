package com.example.lab1.controller;
import com.example.lab1.api.CommonResult;
import com.example.lab1.entity.FundRateTime;
import com.example.lab1.entity.StockPriceTime;
import com.example.lab1.model.MyFund;
import com.example.lab1.model.MyStock;
import com.example.lab1.model.MyTerm;
import com.example.lab1.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RestController
public class FinancialController {
    private final ProductService productService;
    Logger logger= Logger.getLogger(LoanController.class.getName());

    public FinancialController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/financing/account/level")
    @ApiOperation("查询用户等级")
    public CommonResult<Integer> queryAccountLv(@RequestParam String accountNum){
        int lv=productService.getAccountLv(accountNum);
        if (lv<0)
            return CommonResult.failed("accountNum error");
        else
            return CommonResult.success(lv);
    }


    @GetMapping("/financing/product/stock")
    @ApiOperation("查询股票")
    public CommonResult<List<MyStock>> queryAllStock(@RequestParam String code){
        List<MyStock> allStock = productService.queryStockByCustomerCode(code);
        return CommonResult.success(allStock);
    }


    @GetMapping("/financing/product/fund")
    @ApiOperation("查询基金")
    public CommonResult<List<MyFund>> queryAllFund(@RequestParam String code){
        List<MyFund> allFund = productService.queryFundByCustomerCode(code);
        return CommonResult.success(allFund);
    }


    @GetMapping("/financing/product/term")
    @ApiOperation("查询定期理财产品")
    public CommonResult<List<MyTerm>> queryAllTerm(@RequestParam String code){
        List<MyTerm> allTerm = productService.queryTermByCustomerCode(code);
        return CommonResult.success(allTerm);
    }
    @PostMapping("/financing/myProduct/stock/buy")
    @ApiOperation("买入股票")
    public CommonResult<String> buyStock(@RequestBody Map<String,String> param){
        String customerCode= param.get("customerCode");
        String idNumber= param.get("IDNumber");
        String accountNum= param.get("accountNum");
        String password= param.get("password");
        String stockCode= param.get("stockCode");
        int amount=Integer.parseInt(param.get("amount"));
        int flag = productService.buyStock(stockCode, customerCode, idNumber, accountNum, password, amount);
        if (flag<0)
            return CommonResult.failed("buy failed...");
        return CommonResult.success("buy success!");
    }
    @PostMapping("/financing/myProduct/stock/sell")
    @ApiOperation("售出股票")
    public CommonResult<String> sellStock(@RequestBody Map<String,String> param){
        String stockCode= param.get("stockCode");
        String customerCode= param.get("customerCode");
        String idNumber= param.get("IDNumber");
        String accountNum= param.get("accountNum");
        String password= param.get("password");
        int amount=Integer.parseInt(param.get("amount"));
        int flag = productService.sellStock(stockCode, customerCode, idNumber, accountNum, password, amount);
        if (flag<0)
            return CommonResult.failed("sell failed...");
        return CommonResult.success("sell success!");
    }


    @PostMapping("/financing/myProduct/fund/buy")
    @ApiOperation("买入基金")
    public CommonResult<String> buyFund(@RequestBody Map<String,String> param){
        String fundCode=param.get("fundCode");
        String customerCode= param.get("customerCode");
        String idNumber=param.get("IDNumber");
        String accountNum= param.get("accountNum");
        String password=param.get("password");
        double amount=Double.parseDouble(param.get("amount")) ;
        int flag = productService.buyFund(fundCode, customerCode, idNumber, accountNum, password, amount);
        if (flag<0)
            return CommonResult.failed("buy failed...");
        return CommonResult.success("buy success!");
    }

    @PostMapping("/financing/myProduct/fund/sell")
    @ApiOperation("售出基金")
    public CommonResult<String> sellFund(@RequestBody Map<String,String> param){
        String fundCode=param.get("fundCode");
        String customerCode=param.get("customerCode");
        String idNumber=param.get("IDNumber");
        String accountNum=param.get("accountNum");
        String password=param.get("password");
        double amount=Double.parseDouble(param.get("amount"));
        int flag = productService.sellFund(fundCode, customerCode, idNumber, accountNum, password, amount);
        if (flag<0)
            return CommonResult.failed("sell failed...");
        return CommonResult.success("sell success!");
    }

    @PostMapping("//financing/myProduct/term/buy")
    @ApiOperation("买入定期理财产品")
    public CommonResult<String> buyTerm(@RequestBody Map<String,String> param){
        String termCode=param.get("termCode");
        String customerCode= param.get("customerCode");
        String idNumber= param.get("IDNumber");
        String accountNum= param.get("accountNum");
        String password= param.get("password");
        double amount=Double.parseDouble(param.get("amount"));
        int flag = productService.buyTerm(termCode, customerCode, idNumber, accountNum, password, amount);
        if (flag<0)
            return CommonResult.failed("buy failed...");
        return CommonResult.success("buy success!");
    }

    @GetMapping("/financing/product/stock/prices")
    @ApiOperation("查询单只股票历史价格")
    public CommonResult<List<StockPriceTime>> queryStockPriceByStockCode(@RequestParam String code){
        List<StockPriceTime> stockPriceTimes = productService.queryStockPriceByStockCode(code);
        return stockPriceTimes.size()==0?CommonResult.failed("query fail:code error"):CommonResult.success(stockPriceTimes);
    }
    @GetMapping("/financing/product/fund/prices")
    @ApiOperation("查询单个基金历史·利率")
    public CommonResult<List<FundRateTime>> queryFundRateByFundCode(@RequestParam String code){
        List<FundRateTime> fundRateTimes = productService.queryFundRateTimeByFundCode(code);
        return fundRateTimes.size()==0?CommonResult.failed("code error"):CommonResult.success(fundRateTimes);
    }
}
