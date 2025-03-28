import React from 'react'
import Image from 'next/image'
import LogoImpact from '../assets/logo.png'
import about1 from '../assets/hero1.png'
import MagLogo from '../assets/magLogo2.png'


const About = () => {
  return (
    <div className='mt-[180vh] md:mt-[90vh]' id='about'>

<div className='flex flex-col justify-center items-center'>
  <p className='text-black/40 text-sm sm:text-base'>À propos</p>
  <h1 className='text-[#4F4E4E] font-bold text-2xl sm:text-4xl text-center mx-2'>Espace pour l’expression, l’échange et l’engagement des étudiants</h1>
</div>


      <div className='w-full flex flex-wrap justify-around md:p-20 p-8 '>

        <div className='flex flex-col md:w-[40%] hover:scale-110 transition-transform duration-500 cursor-pointer'>
          <Image src={LogoImpact} alt='Logo' height={71} width={163} />
          <h1 className='text-black/40'>À propos de <span className='text-[#EE9F01]'>IMPACT</span></h1>
          <p className='p-5 bg-neutral-50 text-black/40 mt-5 rounded-sm'>Club Impact est un club dynamique dédié aux étudiants passionnés par l'interview, le podcast, la photographie et la communication. Ce club offre une plateforme créative où les membres peuvent développer leurs compétences en media, interviewer des personnalités inspirantes, produire des podcasts captivants et capturer des moments uniques à travers la photographie. Club Impact vise à créer un espace de partage, d'apprentissage et de collaboration pour tous ceux qui souhaitent s'impliquer dans le monde de la communication </p>
        </div>

        <div className="relative mt-14 group">
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

        <div className="relative mt-14 md:mt-24 group">
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

        <div className='flex flex-col mt-14 md:w-[40%] hover:scale-110 transition-transform duration-500 cursor-pointer'>
          <Image src={MagLogo} alt='Logo' height={71} width={163} />
          <h1 className='text-black/40 '>À propos de <span className='text-[#EE9F01]'>Magazine</span></h1>
          <p className='p-5 bg-neutral-50 text-black/40 mt-5 rounded-sm'>Magazine Impact est une plateforme dédiée au partage des idées, des expériences et des hobbies des étudiants. Ce magazine offre un espace où chacun peut exprimer ses passions, découvrir de nouvelles perspectives et s’inspirer des histoires de ses pairs. Que ce soit à travers des articles, des témoignages ou des récits personnels, Magazine Impact vise à créer une communauté engagée, curieuse et ouverte à l’échange. </p>
        </div>


      </div>
    </div>
  )
}

export default About