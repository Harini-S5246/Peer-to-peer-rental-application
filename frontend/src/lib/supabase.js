import {createClient} from '@supabase/supabase-js';
const url=import.meta.env.VITE_SUPABASE_URL;
const pub_key=import.meta.env.VITE_SUPABASE_PUBLISHABLE_KEY;
export const supabase=createClient(url,pub_key);