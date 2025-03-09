"use client"
import Image from 'next/image';
import Footer from './Components/Footer';
import { useRouter } from 'next/navigation';
import Logo from '../app/assets/logo.png'
import Header from './Components/Header';
import Hero from './Components/Hero';
import About from './Components/About';
import Services from './Components/Services';
import Team from './Components/Team';
import SecendFooter from './Components/SecendFooter';
import Notification from './Components/Notification';
import Questions from './Components/Questions';


export default function Home() {
  
  const router = useRouter();
  return (
    <>
      <Header />
      <Hero />
      <About />
      <Services />
      <Questions />
      <Team />
      <SecendFooter />
    {/*
    <div className="flex flex-col items-center justify-center min-h-[90vh] bg-white">
      <Image src={Logo} alt="Logo" width={200} height={50} />
      <h1 className="text-2xl font-bold my-4">Bienvenue sur Magazine Impact</h1>
      <button
        onClick={() => router.push('/login')}
        className="px-6 py-3 bg-yellow-500 text-white rounded-lg shadow-lg hover:bg-yellow-600"
      >
        Se connecter
      </button>
    </div>
    <Footer /> */}

    
    </>
  );
}
