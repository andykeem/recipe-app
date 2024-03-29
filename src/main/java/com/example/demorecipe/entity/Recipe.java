package com.example.demorecipe.entity;

import com.example.demorecipe.enums.Difficulty;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private int prepTime;
    private int cookTime;
    private int servings;
    private String source;
    private String url;

    @Lob
    private String direction;

    @Enumerated(value = EnumType.STRING)
    @Column(length = 24)
    private Difficulty difficulty;

    @Lob
    private byte[] image;

    @OneToOne(mappedBy = "recipe", cascade = CascadeType.ALL)
    private Note note;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private Set<Ingredient> ingredients = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "recipe_category",
            joinColumns = { @JoinColumn(name = "recipe_id") },
            inverseJoinColumns = { @JoinColumn(name = "category_id") })
    private Set<Category> categories = new HashSet<>();

    public Recipe() {
    }

    public Recipe(String description, int prepTime, int cookTime, int servings, String source, String url,
                  String direction, Difficulty difficulty, byte[] image) {
        this.description = description;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.servings = servings;
        this.source = source;
        this.url = url;
        this.direction = direction;
        this.difficulty = difficulty;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    public int getCookTime() {
        return cookTime;
    }

    public void setCookTime(int cookTime) {
        this.cookTime = cookTime;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        note.setRecipe(this);
        this.note = note;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Recipe addIngredient(Ingredient ingredient) {
        ingredient.setRecipe(this);
        ingredients.add(ingredient);
        return this;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Recipe addCategory(Category category) {
        categories.add(category);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return prepTime == recipe.prepTime &&
                cookTime == recipe.cookTime &&
                servings == recipe.servings &&
                Objects.equals(id, recipe.id) &&
                Objects.equals(description, recipe.description) &&
                Objects.equals(source, recipe.source) &&
                Objects.equals(url, recipe.url) &&
                Objects.equals(direction, recipe.direction) &&
                difficulty == recipe.difficulty &&
                Arrays.equals(image, recipe.image) &&
                Objects.equals(note, recipe.note) &&
                Objects.equals(ingredients, recipe.ingredients) &&
                Objects.equals(categories, recipe.categories);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, description, prepTime, cookTime, servings, source, url, direction, difficulty, note, ingredients, categories);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }
}
