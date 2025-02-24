"use client"
import Image from 'next/image';
import Footer from '../Components/Footer';
import { useRouter } from 'next/navigation';
import Logo from '../assets/logo.png'
import Google from '../assets/google.png'
import Link from 'next/link';
import { useState } from 'react';

export default function Signup() {
    const router = useRouter();
    const [email, setEmail] = useState('');
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [confirmPassword, setConfirmPassword] = useState('');
    const [error, setError] = useState('');

    const handleEmailChange = (e) => {
        setEmail(e.target.value);
        setUsername(e.target.value.split('@')[0]);
    };

    const validateEmail = (email) => {
        const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return re.test(String(email).toLowerCase());
    };

    const handleSignup = () => {
        if (!email || !username || !password || !confirmPassword) {
            setError('All fields are required');
            return;
        }
        if (!validateEmail(email)) {
            setError('Invalid email address');
            return;
        }
        if (password !== confirmPassword) {
            setError('Passwords do not match');
            return;
        }
        if (password.length < 6) {
            setError('Password must be at least 6 characters');
            return;
        }
        setError('');
        router.push('/welcome');
    };

    return (
        <>
            <div className="flex flex-col items-center min-h-[90vh] bg-white z-50">
                <div className="flex justify-center py-2">
                    <Image src={Logo} alt="Logo" width={200} height={50} />
                </div>
                <div className="w-full max-w-md bg-white p-8 rounded-3xl shadow-sm border border-2">
                    <h2 className="text-center text-gray-700 mb-4">s'inscrire avec</h2>
                    <div className="flex items-center justify-center">
                        <Link href="#" className="w-full max-w-xs border border-gray-300 rounded-lg py-3 flex justify-center items-center shadow-md hover:bg-gray-50">
                            <Image src={Google} alt="Google Logo" width={27} height={27} />
                        </Link>
                    </div>

                    <p className="text-center my-4 text-gray-500">ou</p>
                    <input
                        type="email"
                        placeholder="Email"
                        value={email}
                        onChange={handleEmailChange}
                        className="w-full p-2 mb-3 border rounded-lg focus:outline-none"
                    />
                    <input
                        type="text"
                        placeholder="Username"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                        className="w-full p-2 mb-3 border rounded-lg focus:outline-none"
                    />
                    <input
                        type="password"
                        placeholder="Password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        className="w-full p-2 mb-3 border rounded-lg focus:outline-none"
                    />
                    <input
                        type="password"
                        placeholder="Confirm Password"
                        value={confirmPassword}
                        onChange={(e) => setConfirmPassword(e.target.value)}
                        className="w-full p-2 mb-3 border rounded-lg focus:outline-none"
                    />
                    {error && <p className="text-red-500 text-center mb-3">{error}</p>}
                    <button
                        onClick={handleSignup}
                        className="w-full p-3 bg-yellow-500 text-white rounded-lg shadow-md hover:bg-yellow-600"
                    >
                        S'inscrire
                    </button>
                    <p className="text-center mt-4 text-gray-700">
                        Vous avez déjà un compte? <Link href="/login" className="font-bold hover:underline">Se connecter</Link>
                    </p>
                </div>
            </div> 
            <div className='mt-3'>
                <Footer />
            </div>
        </>
    );
}