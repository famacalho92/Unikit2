package com.example.unikit.data.network



import io.github.jan.supabase.BuildConfig
import io.github.jan.supabase.annotations.SupabaseInternal
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.GoTrue

object SupabaseClient {

    val client = createSupabaseClient(
        supabaseUrl = "https://vhbutrkzjibajrwtofhm.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InZoYnV0cmt6amliYWpyd3RvZmhtIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MTE4MzU3OTMsImV4cCI6MjAyNzQxMTc5M30.HHwr7GJ9mYPuDUvV1EAvi4nuDomVWZYUyK8t_BW-pUE"
    ) {
        install(GoTrue)
    }
}