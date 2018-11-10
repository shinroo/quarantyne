package com.quarantyne.core.classifiers.impl;

import com.quarantyne.core.classifiers.HttpRequestClassifier;
import com.quarantyne.core.classifiers.Label;
import com.quarantyne.core.lib.HttpRequest;
import com.quarantyne.core.lib.HttpRequestBody;
import java.util.Set;
import javax.annotation.Nullable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SuspiciousRequestHeadersClassifier implements HttpRequestClassifier {

  @Override
  public Set<Label> classify(HttpRequest httpRequest, @Nullable HttpRequestBody body) {
    if (httpRequest.getHeaders().size() <= 5) {
      if (log.isDebugEnabled()) {
        log.debug("suspicious headers: {}", httpRequest.getHeaders());
      }
      return Label.SUSPICIOUS_HEADERS;
    }
    return EMPTY_LABELS;
  }

}
