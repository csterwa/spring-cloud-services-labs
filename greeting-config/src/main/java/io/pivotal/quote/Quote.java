package io.pivotal.quote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RefreshScope
public class Quote {

  private final Logger logger = LoggerFactory.getLogger(QuoteController.class);

  @Value("${quoteServiceURL:}")
  String quoteServiceURL;

  String getQuoteServiceURL() {
    return quoteServiceURL;
  }

  public Quote getQuote() {
    logger.info("quoteServiceURL: {}", quoteServiceURL);
    RestTemplate restTemplate = new RestTemplate();
    Quote quote = restTemplate.getForObject(quoteServiceURL, Quote.class);
    return quote;
  }

}
