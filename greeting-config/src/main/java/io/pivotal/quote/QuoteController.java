package io.pivotal.quote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QuoteController {

  private final Logger logger = LoggerFactory.getLogger(QuoteController.class);

  @Autowired
  private Quote quote;

  @RequestMapping("/random-quote")
  String getRandomQuote(Model model) {
    logger.debug("returning random quote");
    model.addAttribute("quote", quote.getQuote());
    model.addAttribute("uri", quote.getQuoteServiceURL()); 
    return "quote";
  }
  
}