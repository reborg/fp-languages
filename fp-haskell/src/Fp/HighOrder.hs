module Fp.HighOrder where

type Winner = (String, Int)

lotteryStrategy :: Int -> [String] -> [Winner]
lotteryStrategy totalPrize
  | totalPrize > 100 = \tickets -> zip tickets [50, 30, 20]
  | otherwise = \tickets -> zip tickets [10, 10, 10]

display :: [Winner] -> [String]
display winners = map fmt indexedWinners
  where indexedWinners = zip ([1..] :: [Int]) winners
        fmt w = "winner " ++ show (fst w) ++ ": " ++ show (snd w) ++ "\n"

draw :: ([String] -> [Winner]) -> [String] -> [Winner]
draw lottery tickets = lottery $ take 3 tickets

results :: [String] -> Int -> String
results tickets totalPrize =
  show $ display (draw (lotteryStrategy totalPrize) tickets)
