import React from 'react'
import Image from 'next/image'
import LogoImpact from '../assets/logo.png'
import about1 from '../assets/hero1.png'
import MagLogo from '../assets/magLogo2.png'


const About = () => {
  return (
    <div className='mt-16'>

<div className='flex flex-col justify-center items-center'>
  <p className='text-black/40 text-sm sm:text-base'>À propos de nous</p>
  <h1 className='text-[#4F4E4E] font-bold text-2xl sm:text-4xl text-center'>Handshake infographic mass market</h1>
</div>


      <div className='w-full flex flex-wrap justify-around p-20 '>

        <div className='flex flex-col md:w-[40%] hover:scale-110 transition-transform duration-500 cursor-pointer'>
          <Image src={LogoImpact} alt='Logo' height={71} width={163} />
          <h1 className='text-black/40'>À propos de <span className='text-[#EE9F01]'>IMPACT</span></h1>
          <p className='p-5 bg-neutral-50 text-black/40 mt-5 rounded-sm'>Conversion angel investor entrepreneur first mover advantage.
            Handshake infographic mass market crowdfunding iteration. Traction stock user experience deployment beta innovator incubator
            focus. Sales user experience branding growth hacking holy grail monetization conversion prototype stock network effects.
            Learning curve network effects return on investment bootstrapping business-to-consumer. </p>
        </div>

        <div className="relative mt-10 group">
          <div className="absolute -top-6 -right-6 bg-[#FEB92F] rounded-3xl h-full w-full transition-transform duration-500 group-hover:scale-105">
          </div>
          <div className="relative transition-transform duration-500 group-hover:scale-110">
            <Image
              className="h-[302px] w-[387px]"
              src={about1}
              alt="About 1"
            />
          </div>
        </div>

        <div className="relative mt-24 group">
          <div className="absolute -bottom-2 -left-6 bg-[#FEB92F] rounded-3xl h-full w-full transition-transform duration-500 group-hover:scale-105">
          </div>
          <div className="relative transition-transform duration-500 group-hover:scale-110">
            <Image
              className="h-[302px] w-[387px]"
              src={about1}
              alt="About 1"
            />
          </div>
        </div>

        <div className='flex flex-col mt-16 md:w-[40%] hover:scale-110 transition-transform duration-500 cursor-pointer'>
          <Image src={MagLogo} alt='Logo' height={71} width={163} />
          <h1 className='text-black/40 '>À propos de <span className='text-[#EE9F01]'>Magazine</span></h1>
          <p className='p-5 bg-neutral-50 text-black/40 mt-5 rounded-sm'>Conversion angel investor entrepreneur first mover advantage.
            Handshake infographic mass market crowdfunding iteration. Traction stock user experience deployment beta innovator incubator
            focus. Sales user experience branding growth hacking holy grail monetization conversion prototype stock network effects.
            Learning curve network effects return on investment bootstrapping business-to-consumer. </p>
        </div>


      </div>
    </div>
  )
}

export default About