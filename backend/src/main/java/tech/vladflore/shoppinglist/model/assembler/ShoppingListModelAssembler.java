package tech.vladflore.shoppinglist.model.assembler;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import tech.vladflore.shoppinglist.api.impl.ShoppingListApiImpl;
import tech.vladflore.shoppinglist.model.ShoppingList;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ShoppingListModelAssembler implements RepresentationModelAssembler<ShoppingList, EntityModel<ShoppingList>> {
    @Override
    public EntityModel<ShoppingList> toModel(ShoppingList shoppingList) {
        return EntityModel.of(
                shoppingList,
                linkTo(methodOn(ShoppingListApiImpl.class).getShoppingListById(shoppingList.getId())).withSelfRel(),
                linkTo(methodOn(ShoppingListApiImpl.class).allShoppingLists()).withRel("shopping-lists")
        );
    }
}