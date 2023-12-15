package de.samples.apicomparison.provider.domain.events;

import de.samples.apicomparison.provider.domain.model.BlogPost;

public record BlogPostUpdatedEvent(BlogPost blogPost) {

}
