import React from 'react'
import Services1 from '../assets/services1.png'
import Image from 'next/image'


const Services = () => {
    return (
        
        <div className='mb-20'>
            <div className='bg-[#FEB92F] md:py-20 py-10 px-10' id='services'>

                <div className='flex flex-col justify-center items-center'>
                    <p className='text-white/85 text-sm sm:text-base'>À propos de nous</p>
                    <h1 className='text-white/90 font-bold text-2xl sm:text-4xl text-center'>Handshake infographic mass market crowdfunding iteration.</h1>
                </div>

                <div className='flex justify-around md:mt-20 mt-10 flex-wrap gap-4'>

                    <div className="flex items-start gap-4 p-6 w-80 bg-white shadow-lg rounded-2xl">
                        <Image src={Services1} alt="services1" width={50} height={50} className="w-12 h-12 object-contain" />
                        <div>
                            <h1 className="text-xl font-semibold text-gray-900">Design Essentials</h1>
                            <p className="mt-2 text-gray-600 leading-relaxed">
                                Strengthen your brand identity with our comprehensive suite of services, including logo design and brand strategy.
                                Ensure your brand stands out in a crowded market with our tailored solutions.
                            </p>
                        </div>
                    </div>

                    <div className="flex items-start gap-4 p-6 w-80 bg-white shadow-lg rounded-2xl">
                        <Image src={Services1} alt="services1" width={50} height={50} className="w-12 h-12 object-contain" />
                        <div>
                            <h1 className="text-xl font-semibold text-gray-900">Design Essentials</h1>
                            <p className="mt-2 text-gray-600 leading-relaxed">
                                Strengthen your brand identity with our comprehensive suite of services, including logo design and brand strategy.
                                Ensure your brand stands out in a crowded market with our tailored solutions.
                            </p>
                        </div>
                    </div>

                    <div className="flex items-start gap-4 p-6 w-80 bg-white shadow-lg rounded-2xl">
                        <Image src={Services1} alt="services1" width={50} height={50} className="w-12 h-12 object-contain" />
                        <div>
                            <h1 className="text-xl font-semibold text-gray-900">Design Essentials</h1>
                            <p className="mt-2 text-gray-600 leading-relaxed">
                                Strengthen your brand identity with our comprehensive suite of services, including logo design and brand strategy.
                                Ensure your brand stands out in a crowded market with our tailored solutions.
                            </p>
                        </div>
                    </div>
                </div>
            </div>

            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1000 100"><g fill="#FEB92F"><path d="M0 0v84l500 16 500-16V0H0z" opacity=".2"></path><path d="M0 0v64l500 36 500-36V0H0z" opacity=".4"></path><path d="M0 0v44l500 56 500-56V0H0z" opacity=".4"></path><path d="M0 0v24l500 76 500-76V0H0z" opacity=".5"></path><path d="M0 0v4l500 96 500-96V0H0z"></path></g></svg>
        </div>
    )
}

export default Services