package com.jhkwon91.hackingspringboot.reactive;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Links;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class HypermediaItemController {

    private final ItemRepository repository;


    public HypermediaItemController(ItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/hypermedia/items/{id}")
    Mono<EntityModel<Item>> findOne(@PathVariable String id) {
        HypermediaItemController controller = methodOn(HypermediaItemController.class);

        Mono<Link> selfLink = Mono.just(linkTo(controller.findOne(id)).withSelfRel());

        Mono<Link> aggregateLink = Mono.just(linkTo(controller.findAll()).withRel(IanaLinkRelations.ITEM));

        return Mono.zip(repository.findById(id), selfLink, aggregateLink)
                .map(o->EntityModel.of(o.getT1(), Links.of(o.getT2(), o.getT3())));

    }

    private Flux<EntityModel<Item>> findAll() {

        return Flux.empty();
    }
}
