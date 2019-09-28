package com.chunkit.wifi_monitor.entity;

/**
 * @auther ChunKit
 * @date 2019/9/9-19:16
 */
public class Zone {
    int id;
    String name;
    String description;
    Double x;
    Double y;
    String imagePath;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Zone() {

    }

    public Zone(int id, String name, String description, Double x, Double y, String imagePath) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.x = x;
        this.y = y;
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "Zone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
