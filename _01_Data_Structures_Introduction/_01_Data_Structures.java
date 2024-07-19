package _01_Data_Structures_Introduction;

public class _01_Data_Structures {
    public static void main(String[] args) {
        /**
         * Q. Why do we use data structures?
         * => 1. Store data
         * => 2. Retrieve data
         * 
         * => Let's say a table is a data structure. Here, we are trying to
         *    place some of our belongings like green, black, pink, purple,
         *    & read t-shirt.
         * => There is one organized person who have a cupboard and in that
         *    they have different-different shelves for storing the tshirt.
         *    So, there are two data structures:
         *    (a) Cupboard data structure
         *    (b) Table data structure
         * 
         * Q. Which one is better? Storing in table or cupboard?
         * => Cupboard
         * 
         * Q. What is the time complexity for retrieving green t-shirt from table?
         * => We will come and see that the green t-shirt is lying on the table.
         *    We will pick it up and do whatever we want to do with it. So, TC
         *    is O(1).
         * => But if we want to retrieve the green tshirt from the cupboard, first
         *    we have to pull out the red one first then pink one, then only
         *    we will get this green tshirt.
         * 
         * Q. Which one is better in case of retrieval?
         * => Table data structure.
         * 
         * Q. Where is it easy to store? Storing tshirt somewhere at table or
         *    storing properly the folded tshirt in the cupboard?
         * => Table data structure 
         * 
         * Although this table data structure doesn't look good, doesn't look
         * like organized data but remember it doesn't always good to have 
         * organized data. If storing and retrieval is faster in unorganized
         * data then this is also better sometimes. So, based on this we have
         * different different data structures and we will see :
         *    1. Which data structures is good for us in which use cases?
         *    2. We will compare the time complexity & space complexity?
         * Note: It's not always true that if storing is fast then retrieval will
         *       also be fast.
         * 
         * 
         * Data Structures:
         * (a) Linear Data Structures
         * (b) Non-Linear Data Structures
         * 
         * Q. From 1980s till now, if we have 1 million accounts in bank, and 
         *    you are going to search your account balance or last months 
         *    transactions etc. To get the result, do you think it will take a 
         *    lot of time to fetch all the details?
         * => For this they create two types of storage:
         *    (a) OLAP: Online Analytical Process (Old data)
         *    (b) OLTP: Online Transaction Process (Transaction means which is going regularly)
         * => In OLAP, they will have older data, everything from 1980 to 2015 in
         *    this one bucket, so huge chunk of data is stored in this storage,
         *    let's say 10PB.
         * => If someone who create account between 1980-2015, wants to see 
         *    their transaction. For them it is going to take a lot of time.
         *    But if you have create after 2015, here the data will be comparatively
         *    less or if it is more then again we will separate it into multiple
         *    buckets.
         *    (a) Storage-1: 2016-2020
         *    (b) Storage-2: 2021 till now
         * => This way amount to be searched, search space will be lesser. And
         *    data between 1980-2015 wil come once in a while. But if you are
         *    our regular customer making daily transaction, and checking 
         *    transactions daily then you will be put to tier-1 category, but
         *    searching system will be same. This might not be related to year
         *    but can be on the basis of transactions also, but OLTP between
         *    2021 till now, searching will be very fast because less data is
         *    there is this storage. Every system follows this, even banking
         *    system.
         * => Space is less then response would be faster.
         * 
         * 
         * Data Structures:
         * 1. Linear Data Structure
         *    a. Static Data Structure:
         *       i. Array
         *    b. Dynamic Data Structure:
         *       i. ArrayList/List
         *      ii. LinkedList
         *     iii. Stack
         *      vi. Queue
         * 
         * 2. Non-Linear Data Structure:
         *    a. Tree
         *    b. Graph
         * 
         * Q. How do we differentiate between linear DS & non-linear DS?
         * 1. Linear Data Structure:
         * => It is guaranteed that :
         *    (a) At max, one element will be before you, and 
         *    (b) At max, one element will be after you.
         * 
         * 2. Non-Linear Data Structure:
         * => It is guaranteed that:
         *    (a) more than one element will be after you.
         *    (b) more than one element can be behind you also.
         * */ 

        /**
         * LinkedList:
         * => If we are creating any array, elements are contiguous
         * => 30:00
        */
    }
}
