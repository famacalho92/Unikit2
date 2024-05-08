package network

import io.github.jan.supabase.buildUrl
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
//import io.github.jan.supabase.gotrue.GoTrue

object SupaBaseClient {
    val supabase = createSupabaseClient(
        supabaseUrl = "https://vhbutrkzjibajrwtofhm.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InZoYnV0cmt6amliYWpyd3RvZmhtIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MTE4MzU3OTMsImV4cCI6MjAyNzQxMTc5M30.HHwr7GJ9mYPuDUvV1EAvi4nuDomVWZYUyK8t_BW-pUE"
    ) {
        install(Postgrest)
    }
}