package com.alameendev.fooddeliveryapp.db;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.alameendev.fooddeliveryapp.model.Cart;
import com.alameendev.fooddeliveryapp.model.Dish;
import com.alameendev.fooddeliveryapp.model.FOOD_ENUMS.DishType;
import com.alameendev.fooddeliveryapp.model.FOOD_ENUMS.UserType;
import com.alameendev.fooddeliveryapp.model.Hotel;
import com.alameendev.fooddeliveryapp.model.UniqueId;
import com.alameendev.fooddeliveryapp.model.User;
import com.alameendev.fooddeliveryapp.serializer.ObjectSerializer;

public class FoodDB {
	
	private static FoodDB foodDB;
	
	private User currentUser;
	UniqueId uniqueId;
	private List<User> userList = new LinkedList<User>();
	private List<Cart> cartList = new LinkedList<Cart>();
	private List<Dish> dishList = new LinkedList<Dish>();
	private List<Hotel> hotelList = new LinkedList<Hotel>();
	
	
	private final String UNIQUE_ID_FILE_NAME = "uniqueid";
	private final String USER_FILE_NAME = "user";
	private final String CART_FILE_NAME = "cart";
	private final String dISH_FILE_NAME = "dish";
	
	private FoodDB() {
		try {
			if(ObjectSerializer.serialize().getBooksFromTheDisk(UNIQUE_ID_FILE_NAME) != null){
				uniqueId = ObjectSerializer.serialize().getBooksFromTheDisk(UNIQUE_ID_FILE_NAME);
			}else {
				uniqueId = UniqueId.id();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static FoodDB getInstance() {
		if(foodDB == null) {
			foodDB = new FoodDB();
		}
		return foodDB;
	}

	public void setCurrentUser(User user) {
		this.currentUser = user;
	}
	
	public User getCurrentUser() {
		return currentUser;
	}
	public List<User> getUserList() {
		return userList;
	}

	public void createUser(String userName, String password, String address, String phoneNo, char role) {
		UserType type = null;
		if(Character.toUpperCase(role) == 'H') {
			type = UserType.ADMIN;
		}else if(Character.toUpperCase(role) == 'U') {
			type = UserType.USER;
		}else if(Character.toUpperCase(role) == 'D') {
			type = UserType.DELILVERY_BOY;
		}
		User user = new User.Builder().userId(uniqueId.getUserId()).name(userName).address(address).password(password).phoneNo(phoneNo).role(type).build();
		UniqueId.id().incrementUserId();
		userList.add(user);
		System.out.println(user);
	}

	public List<Hotel> getHotelList() {
		return hotelList;
	}
	
	public List<Hotel> getHotelList(User user){
		return hotelList.stream().filter(hotel->hotel.getAdmin() == user.getUserId()).toList();
	}

	public void addHotel(String name, char type, String phoneNo, String address) {
		DishType dish = null;
		if(Character.toUpperCase(type) == 'V') {
			dish = DishType.VEG;
		}else if(Character.toUpperCase(type) == 'N') {
			dish = DishType.NON_VEG;
		}
		Hotel hotel = new Hotel.Builder().phoneNo(phoneNo)
				.hotelId(uniqueId.getHotelId()).address(address).name(name).dishType(dish).adminId(getCurrentUser().getUserId()).build();
		uniqueId.incrementHotelId();
		hotelList.add(hotel);
		System.out.println(hotel);
		
	}

	public void createDish(long hotelId, String name, int price, char dishType) {
		DishType dish = null;
		if(Character.toUpperCase(dishType) == 'V') {
			dish = DishType.VEG;
		}else if(Character.toUpperCase(dishType) == 'N') {
			dish = DishType.NON_VEG;
		}
		Dish dishObj = new Dish.Builder().dishId(uniqueId.getDishId()).hotelId(hotelId).name(name).name(name).userId(currentUser.getUserId()).price(price).dishType(dish).build();
		uniqueId.incrementDishId();
		dishList.add(dishObj);
		
	}

	public List<Dish> getDishList(long hotelId) {
		return dishList.stream().filter(dish->dish.getHotelId() == hotelId).toList();
	}

	public boolean addDishToCart(long dishId) {
		Dish dish = dishList.stream().filter(d->d.getDishId() == dishId).findFirst().orElse(null);
		if(dish != null) {
			Cart cart = cartList.stream().filter(c->c.getUserId() == currentUser.getUserId()).findFirst().orElse(null);
			if(cart == null) {
				cart = new Cart(uniqueId.getCartId(),currentUser.getUserId());
				cartList.add(cart);
				cart.addToCart(dish);
				uniqueId.incrementCartId();
				return true;
			}else {
				cart.addToCart(dish);
				return true;
			}
		}
		return false;
	}

	public Cart getCartForUser() {
		Cart cart = cartList.stream().filter(c->c.getUserId() == currentUser.getUserId()).findFirst().orElse(null);
		if(cart == null) {
			cart = new Cart(uniqueId.getCartId(),currentUser.getUserId());
			uniqueId.incrementCartId();
			return cart;
		}else {
			return cart;
		}
	}
}
