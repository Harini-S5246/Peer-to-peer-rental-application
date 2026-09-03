import React,{useState,useEffect} from 'react';
import { supabase } from '../lib/supabase';

function HomePage() {
    const [accessToken,setAccessToken]=useState(null);
    const [loading,setLoading]=useState(true);

    useEffect(()=>{
        async function getSessionData(){
            const{data:{session}} =await supabase.auth.getSession();
            setAccessToken(session?.access_token||null);
            setLoading(false);
        }
        getSessionData();
    },[]);

    if(loading){
        return <div style={{textAlign: 'center',marginTop:'50ox'}}>Loading sessiong...</div>;
    }
    

    return (
        <div style={{ textAlign: 'center', marginTop: '50px' }}>
        <h1>Hello welcome to home page</h1>
        <p>Welcome to my React application. Underconstruction  this is ur access token </p>
        <p>Status: {accessToken ? "Authenticated" : "Not Logged In"}</p>
        </div>
    );
}

export default HomePage;