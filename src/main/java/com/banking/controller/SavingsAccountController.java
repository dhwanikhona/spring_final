package com.banking.controller;

import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banking.model.SavingsTransfers;
import com.banking.model.User;
import com.banking.model.SavingsAccount;
import com.banking.model.SavingsTransaction;
import com.banking.servcie.RegisterService;
import com.banking.servcie.SavingsAccountService;
import com.banking.servcie.SavingsTransactionService;
import com.banking.servcie.SavingsTransfersService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SavingsAccountController {
	
	@Autowired
	private SavingsTransfersService transfersService;
	
	@Autowired
	private RegisterService registerService;
	
    @Autowired
    private SavingsTransactionService transactionService;
	
	@Autowired
	private SavingsAccountService savingsAccountService;
	
//	@PostMapping("/savingsAccount")
//	public SavingsAccount createSavingsAccount() {
//		return savingsAccountService.createSavingsAccount();
//	}
	
	@GetMapping("/savingsAccount/accountBalance")
	public ResponseEntity <String> getSavingsAccountBalance(@RequestParam("username") String username) {
		User user= registerService.findByUsername(username);
		int savingsAccountId = user.getSavingsAccount().getSavingsAccountId();
		//System.out.println(savingsAccountId);
		String bal=savingsAccountService.getSavingsAccountBalance(savingsAccountId);
		//System.out.println(bal);
		
//		return bal;
  	  return new ResponseEntity<>(bal, HttpStatus.OK);
	}
	
	
//    @RequestMapping(value = "/savingsAccount", method = RequestMethod.GET)
//    public ResponseEntity <String> savingsAccount(@RequestParam("username") String username) {
//        List<SavingsTransaction> savingsTransactionList = transactionService.findSavingsTransactionList(username);
////        User user = registerService.findByUsername(username);
////       SavingsAccount savingsAccount = user.getSavingsAccount();
//
// //       model.addAttribute("savingsAccount", savingsAccount);
//        model.addAttribute("savingsTransactionList", savingsTransactionList);
//;
//  	  return new ResponseEntity<>("savingsAccount", HttpStatus.OK);
//    }
    
    
	@GetMapping("/getalltransaction")
	public ResponseEntity <List<SavingsTransaction>> findSavingsTransactionList(@RequestParam("username") String username) {
		List<SavingsTransaction> transaction= transactionService.findSavingsTransactionList(username) ;
		
		return new ResponseEntity<> ( transaction, HttpStatus.OK);
	}
    
	
    @RequestMapping(value = "/deposit", method = RequestMethod.GET)
    public ResponseEntity <String> deposit(Model model) {
//        model.addAttribute("accountType", "");
        model.addAttribute("amount", "");

    	  return new ResponseEntity<>("Deposit get", HttpStatus.OK);
    }

    @RequestMapping(value = "/deposit", method = RequestMethod.POST)
    public ResponseEntity <String> depositPOST(@RequestParam("amount") String amount, @RequestParam("username") String username) {
    	savingsAccountService.deposit(Double.parseDouble(amount), username);
    	
    	  return new ResponseEntity<>("Deposit post", HttpStatus.OK);
    }

   //     return "redirect:/userFront";
    

    @RequestMapping(value = "/withdraw", method = RequestMethod.GET)
    public ResponseEntity <String> withdraw(Model model) {
//        model.addAttribute("accountType", "");
        model.addAttribute("amount", "");
        
  	  return new ResponseEntity<>("Withdraw post", HttpStatus.ACCEPTED);

//        return "withdraw";
    }

    @RequestMapping(value = "/withdraw", method = RequestMethod.POST)
    public ResponseEntity <String> withdrawPOST(@RequestParam("amount") String amount, @RequestParam("username") String username) {
    	System.out.println(amount);
    	Double amt = Double.parseDouble(amount);
    	System.out.println(amt);
    	savingsAccountService.withdraw(Double.parseDouble(amount), username);
    	
  	  return new ResponseEntity<>("Withdraw post", HttpStatus.OK);

//        return "redirect:/userFront";
    
    }
    
    @GetMapping("/getSavingsAccount")
	public ResponseEntity <SavingsAccount> getSavingsAccount(@RequestParam("username") String username) {
		System.out.println("in get savings acoount");
    	User user= registerService.findByUsername(username);
    	SavingsAccount savingsAccount = user.getSavingsAccount(); 

  	  return new ResponseEntity<>(savingsAccount, HttpStatus.OK);
	}
    
    
    @GetMapping("/getSavingsAccount/accountNumber")
	public ResponseEntity <Long> getSavingsAccountNumber(@RequestParam("username") String username) {
		System.out.println("in get savings acoount");
    	User user= registerService.findByUsername(username);
    	long savingsAccountNumber = user.getSavingsAccount().getAccountNumber(); 

  	  return new ResponseEntity<>(savingsAccountNumber, HttpStatus.OK);
	}

    
    
    
    
}
