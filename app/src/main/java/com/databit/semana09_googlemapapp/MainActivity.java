package com.databit.semana09_googlemapapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

// implements OnMapReadyCallback: Indica que MainActivity implementa la interfaz OnMapReadyCallback.
// Esto sugiere que esta clase está relacionada con el uso de mapas en la plataforma Android.
// La interfaz OnMapReadyCallback es utilizada para recibir una notificación cuando el mapa está listo para ser utilizado.
public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap myMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Esta es una clase proporcionada por la API de Google Maps para Android. Representa un fragmento que contiene un mapa de Google
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        //getMapAsync(this): Este método se utiliza para obtener de manera asíncrona una instancia de GoogleMap.
        // El mapa no está inmediatamente disponible después de agregar el fragmento, ya que puede llevar un tiempo inicializarse.
        // Por lo tanto, getMapAsync permite que la inicialización del mapa se realice en segundo plano,
        // sin bloquear la ejecución de la interfaz de usuario principal.
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        myMap= googleMap;

        // Es un objeto del tipo LatLng que representa las coordenadas de la ciudad a la que se desea mover la cámara.
        LatLng ubicacion=new LatLng(-30.6045845, -71.2073349);

        // addMarker(...): Este es un método que se utiliza para agregar un marcador al mapa.
        // Esto crea una nueva instancia de MarkerOptions, que probablemente sea un objeto que contiene varias
        // opciones para personalizar la apariencia y el comportamiento del marcador.
        myMap.addMarker(new MarkerOptions().position(ubicacion).title("IP Santo Tomas"));

        // CameraUpdateFactory.newLatLng(ubicacion): Esto mueve la cámara del mapa para que esté centrada en la ubicación
        // especificada por la variable ubicacion.
        // Es probable que ubicacion contenga las coordenadas de latitud y longitud.
        myMap.moveCamera(CameraUpdateFactory.newLatLng(ubicacion));

        // Esto establece el nivel de zoom de la cámara en 15. El nivel de zoom 15 es moderado y muestra una zona más detallada.
        myMap.moveCamera(CameraUpdateFactory.zoomTo(15));

        // getUiSettings(): Esto obtiene un objeto que controla la configuración de la interfaz de usuario del mapa.
        // setZoomControlsEnabled(true): Esto habilita los controles de zoom en el mapa.
        // Los controles de zoom permiten a los usuarios acercar y alejar el mapa.
        myMap.getUiSettings().setZoomControlsEnabled(true);

        // etCompassEnabled(true): Esto habilita la brújula en el mapa. La brújula muestra la orientación del mapa
        // en relación con los puntos cardinales (norte, sur, este, oeste).
        myMap.getUiSettings().setCompassEnabled(true);

        // setZoomGesturesEnabled(false): Deshabilita la capacidad de hacer zoom utilizando gestos,
        // como pellizcar con los dedos en una pantalla táctil.
        myMap.getUiSettings().setZoomGesturesEnabled(false);

        // setScrollGesturesEnabled(false): Deshabilita la capacidad de desplazarse por el mapa utilizando gestos,
        // como deslizar el dedo sobre la pantalla.
        myMap.getUiSettings().setScrollGesturesEnabled(false);
    }
}