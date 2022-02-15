package hackerrank;

import java.util.HashMap;

public class FurnitureOrder implements FurnitureOrderInterface {
    /**
     * TODO: Create a map of Furniture items to order quantities
     */

    private final HashMap<Furniture,Integer> mapFurnitures;
    
    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    FurnitureOrder() {
       mapFurnitures = new HashMap<Furniture,Integer>();
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
        Integer count = 0;
        if(mapFurnitures.containsKey(type)){
              count =  mapFurnitures.get(type);
        }
        mapFurnitures.put(type,count + furnitureCount);
    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
        // TODO: Complete the method
        return new HashMap<Furniture, Integer>(mapFurnitures);
    }

    public float getTotalOrderCost() {
        if(!mapFurnitures.isEmpty()) {
            return mapFurnitures.entrySet().stream().map(fun -> fun.getKey().cost() * fun.getValue()).collect(Collectors.toList()).stream().reduce(Float::sum).get();
        }    
        return 0.0f;
    }

    public int getTypeCount(Furniture type) {
        if(mapFurnitures.containsKey(type)){
            return mapFurnitures.get(type);   
        }    
        return 0;
    }

    public float getTypeCost(Furniture type) {
        if(mapFurnitures.containsKey(type)){
            return mapFurnitures.get(type) * type.cost();   
        }
        return 0.0f;
    }

    public int getTotalOrderQuantity() {
        if(!mapFurnitures.isEmpty()){
            return mapFurnitures.values().stream().reduce(Integer::sum).get();
        }  
        return 0;
    }
}
