"use client"
import Image from 'next/image';
import Footer from '../Components/Footer';
import { useRouter } from 'next/navigation';
import Logo from '../assets/logo.png'
export default function Welcome() {
  const router = useRouter();

  return (
    <>    
    <div className="flex flex-col items-center justify-center min-h-[90vh] bg-white">
    <Image src={Logo} alt="Logo" width={200} height={50} />
    <h1 className="text-2xl font-bold my-4">Bienvenue sur Magazine Impact</h1>
    <button
        onClick={() => router.push('/login')}
        className="px-6 py-3 bg-yellow-500 text-white rounded-lg shadow-lg hover:bg-yellow-600"
    >
        Se deconnecter
    </button>
    </div>
    <Footer />
    </>
  );
}