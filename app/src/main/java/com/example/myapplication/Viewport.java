package com.example.myapplication;

import android.graphics.Rect;

public class Viewport {

    private Vector2Point5D currentViewportWorldCentre;
    private Rect convertedRect;
    private int pixelPerMetreX;
    private int pixelPerMetreY;
    private int screenXResolution;
    private int screenYResolution;
    private int screenCenterX;
    private int screenCenterY;
    private int metresToShowX;
    private int metresToShowY;
    private int numClipped;

    Viewport(int x, int y) {
        screenXResolution = x;
        screenYResolution = y;

        screenCenterX = screenXResolution / 2;
        screenCenterY = screenYResolution / 2;

        pixelPerMetreX = screenXResolution / 32;
        pixelPerMetreY = screenYResolution / 18;

        metresToShowX = 34;
        metresToShowY = 20;

        convertedRect = new Rect();
        currentViewportWorldCentre = new Vector2Point5D();
    }

    void setWorldCentre(float x, float y) {
        currentViewportWorldCentre.x = x;
        currentViewportWorldCentre.y = y;
    }

    public int getScreenWidth() {
        return screenXResolution;
    }

    public int getScreenHeight() {
        return screenYResolution;
    }

    public int getPixelPerMetreX() {
        return pixelPerMetreX;
    }

    public Rect worldToScreen(
            float objectX,
            float objectY,
            float objectWidth,
            float objectHeight
    ) {
        int left = (int) (screenCenterX - ((currentViewportWorldCentre.x) - objectX) * pixelPerMetreX);
        int top = (int) (screenCenterY - ((currentViewportWorldCentre.y) - objectY) * pixelPerMetreY);
        int right = (int) (left + (objectWidth * pixelPerMetreX));
        int bottom = (int) (top + (objectHeight * pixelPerMetreY));

        convertedRect.set(left, top, right, bottom);

        return convertedRect;
    }

}
