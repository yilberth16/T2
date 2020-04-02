package com.example.contactos;

import android.os.Parcel;
import android.os.Parcelable;

public class Usuario implements Parcelable {
   private String nombre;
    private  String telefono;
    private String ahorro;
    private String corriente;
    private String saldo;


    public Usuario() {
    }

    public Usuario(String nombre, String telefono, String ahorro, String corriente, String saldo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.ahorro = ahorro;
        this.corriente = corriente;
        this.saldo = saldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getAhorro() {
        return ahorro;
    }

    public void setAhorro(String ahorro) {
        this.ahorro = ahorro;
    }

    public String getCorriente() {
        return corriente;
    }

    public void setCorriente(String corriente) {
        this.corriente = corriente;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public static Creator<Usuario> getCREATOR() {
        return CREATOR;
    }

    protected Usuario(Parcel in) {
        nombre = in.readString();
        telefono = in.readString();
        ahorro = in.readString();
        corriente = in.readString();
        saldo = in.readString();
    }

    public static final Creator<Usuario> CREATOR = new Creator<Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel in) {
            return new Usuario(in);
        }

        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(telefono);
        dest.writeString(ahorro);
        dest.writeString(corriente);
        dest.writeString(saldo);
    }
}
