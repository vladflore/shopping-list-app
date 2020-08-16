package tech.vladflore.shoppinglist;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import tech.vladflore.shoppinglist.model.Item;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

//@Component
public class ItemModelAssembler implements RepresentationModelAssembler<Item, EntityModel<Item>> {
    @Override
    public EntityModel<Item> toModel(Item item) {
        return EntityModel.of(
                item,
                linkTo(methodOn(ItemApiImpl.class).getItemById(item.getId())).withSelfRel(),
                linkTo(methodOn(ItemApiImpl.class).allItems()).withRel("items")
        );
    }
}
