import React from 'react'
import {
    Accordion,
    AccordionContent,
    AccordionItem,
    AccordionTrigger,
  } from "@/components/ui/accordion"

const Questions = () => {
  return (
    <div className='mb-20'>
      <div className='flex flex-col justify-start items-start ml-4 md:ml-14'>
        <p className='text-black/40 text-sm sm:text-base'>Questions</p>
        <h1 className='text-[#4F4E4E] font-bold text-2xl sm:text-4xl text-left'>Frequently Asked Questions</h1>
      </div>
      <Accordion type="single" collapsible className="flex w-full max-w-md justify-center items-center flex-col mt-10 mx-auto bg-white p-6 rounded-lg shadow-lg">
  <AccordionItem value="item-1">
    <AccordionTrigger className="text-xl font-semibold text-[#FDAD12] hover:text-orange-400 transition duration-300">
      Is it accessible?
    </AccordionTrigger>
    <AccordionContent className="text-gray-700 mt-2 text-sm">
      Yes. It adheres to the WAI-ARIA design pattern and follows accessibility standards.
    </AccordionContent>
  </AccordionItem>
  
  <AccordionItem value="item-2">
    <AccordionTrigger className="text-xl font-semibold text-[#FDAD12] hover:text-orange-400 transition duration-300">
      Is it styled?
    </AccordionTrigger>
    <AccordionContent className="text-gray-700 mt-2 text-sm">
      Yes. It comes with default styles that match the aesthetic of modern UI components, but can be customized.
    </AccordionContent>
  </AccordionItem>

  <AccordionItem value="item-3">
    <AccordionTrigger className="text-xl font-semibold text-[#FDAD12] hover:text-orange-400 transition duration-300">
      Is it animated?
    </AccordionTrigger>
    <AccordionContent className="text-gray-700 mt-2 text-sm">
      Yes. It's animated by default, but you can disable animations if you prefer a static experience.
    </AccordionContent>
  </AccordionItem>

  <AccordionItem value="item-4">
    <AccordionTrigger className="text-xl font-semibold text-[#FDAD12] hover:text-orange-400 transition duration-300">
      Can I customize the content?
    </AccordionTrigger>
    <AccordionContent className="text-gray-700 mt-2 text-sm">
      Absolutely! The accordion component is fully customizable with Tailwind's utility classes or custom styles.
    </AccordionContent>
  </AccordionItem>

  <AccordionItem value="item-5">
    <AccordionTrigger className="text-xl font-semibold text-[#FDAD12] hover:text-orange-400 transition duration-300">
      How does it perform on mobile?
    </AccordionTrigger>
    <AccordionContent className="text-gray-700 mt-2 text-sm">
      It’s fully responsive and works smoothly across different devices, providing an optimal experience on mobile.
    </AccordionContent>
  </AccordionItem>
</Accordion>

    </div>
  )
}

export default Questions