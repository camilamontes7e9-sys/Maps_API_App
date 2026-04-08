package com.example.mapsapiapp.network

import android.net.http.HttpResponseCache.install

object SupabaseClient {
    val client = createSupabaseClient(
        supabaseUrl = "https://vzvkihhszrapfwruwfcp.supabase.co",
        supabaseKey = "sb_publishable_H0xAwFxv6pxTcfw_YWrheQ_WTQeYWgR"
    ) {
        install(Postgrest)
    }
}