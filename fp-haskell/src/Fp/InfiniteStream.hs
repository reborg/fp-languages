module Fp.InfiniteStream where

import Text.Printf (printf)
import System.Random

randInt :: Int -> Int
randInt len = head $ take 1 $ randomRs (0, len) (mkStdGen len)

randString :: Int -> String
randString len = take len $ randomRs ('A', 'Z') (mkStdGen len)

nextTicket :: String
nextTicket = printf "%03d%s%06d" (randInt 999) (randString 2) (randInt 999999)

ticketGen :: [String]
ticketGen = nextTicket:ticketGen

-- Not truly random (it needs different seeds):
-- take 3 ticketGen
