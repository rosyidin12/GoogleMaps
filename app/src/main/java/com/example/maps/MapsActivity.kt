package com.example.maps

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap




        val latitude = -7.747033
        val longitude =  110.355398
        val latitudeMalioboro = -7.793778
        val longtitudeMalioboro = 110.365707
        val lattugu = -7.783031
        val longtugu = 110.367056
        val zoomLevel =15f
        val overlaySize = 100f

        val homeLatLng = LatLng(latitude,longitude)
        mMap.addMarker(MarkerOptions().position(homeLatLng).title("Universitas Teknologi Yogjakarta").snippet("-7.747033/110.355398"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(homeLatLng,zoomLevel))

        val malioboro = LatLng(latitudeMalioboro,longtitudeMalioboro)
        mMap.addMarker(MarkerOptions().position(malioboro).title("Malioboro").snippet("-7.793778/110.365707").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))

        val tugu = LatLng(lattugu,longtugu)
        mMap.addMarker(MarkerOptions().position(tugu).title("Tugu Jogja").snippet("-7.783031/110.367056").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))


        val googleOverlay= GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.kampusuty)).position(homeLatLng,overlaySize)
        mMap.addGroundOverlay(googleOverlay)

        val googleOverlay3= GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.malioboro)).position(malioboro,overlaySize)
        mMap.addGroundOverlay(googleOverlay3)

        val googleOverlay2= GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.tugu)).position(tugu,overlaySize)
        mMap.addGroundOverlay(googleOverlay2)
    }}