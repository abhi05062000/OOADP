// Protected variation
// It is a design principle that emphasizes protecting the higher-level components from variations
// or changes in lower-level components.The key idea is to create an interface 
// or abstraction that shields the higher level components from the detials of lower level components are 
// implemented.This helps in acheiving loose level coupling,flexibility and ease of substitution.

// interface defining a Payment Processor contract
interface PaymentProcessor {
    void processPayment(double amount);
}

// Concrete implementation of PaymentProcessor for Credit Card payments 
class CreditCardPaymentProcessor implements PaymentProcessor {
    
    @Override
    
    public void processPayment(double amount){
        //Logic for processing credit card payment 
        System.out.println("Processing credit card payment for amount: "+amount);
    }
}

//Concrete implementation of PaymentProcessor for Paypal payments

class PaypalPaymentProcessor implements PaymentProcessor{
    @Override
    
    public void processPayment(double amount){
        //Logic for processing Paypal amount
        System.out.println("Processing Paypal amount: "+amount);
    }
}

class PaymentHandler{
    private PaymentProcessor paymentProcessor;
    
    PaymentHandler(PaymentProcessor paymentProcessor){
        this.paymentProcessor = paymentProcessor;
    }
    
    void processPayment(double amount){
        paymentProcessor.processPayment(amount);
    }
}

public class Main{
    public static void main(String [] args){
        CreditCardPaymentProcessor credit = new CreditCardPaymentProcessor();
        PaymentHandler obj = new PaymentHandler(credit);
        obj.processPayment(1200.5);
        
        PaypalPaymentProcessor paypal = new PaypalPaymentProcessor();
        PaymentHandler ob = new PaymentHandler(paypal);
        ob.processPayment(2220.5);
    }
}
