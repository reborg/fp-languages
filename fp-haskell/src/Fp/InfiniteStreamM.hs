module Fp.InfiniteStreamM where

import Text.Printf (printf)
import System.Random
import Control.Monad

randInt :: Int -> IO Int
randInt len = do
  g <- newStdGen
  return $ head $ take 1 $ randomRs (0, len) g

randString :: Int -> IO String
randString len = do
  g <- newStdGen
  return $ take len $ randomRs ('A', 'Z') g

nextTicket :: IO String
nextTicket = do
  prefix <- randInt 999
  letters <- randString 2
  suffix <- randInt 999999
  return $ printf "%03d%s%06d" prefix letters suffix

ticketGen :: Int -> IO [String]
ticketGen n = replicateM n nextTicket
