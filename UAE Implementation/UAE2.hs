module UAE2 where
    data T = 
        --Truthiness
        -- | Falsiness
        --Zero
        IfThenElse T T T
        | Succ T
        | Pred T
        | IsZero T
        | Val Value
        deriving (Show,Eq)

    data Value = Truthiness | Falsiness | NValue NumericValue | Wrong
                deriving (Show,Eq)
    data NumericValue = Zero | NVSucc NumericValue 
                deriving (Show,Eq)

    ssos :: T ->  T
    --ssos (Succ t)= Val(NValue(NVSucc t))
    --ssos (Succ t)= (Succ Zero)
    --ssos d = d
    --ssos (Succ e) = e
    --Reflexive stuff DONE
    ssos (Val Wrong) = (Val Wrong)
    ssos (Val Truthiness) = (Val Truthiness)
    ssos (Val Falsiness) = (Val Falsiness)
    ssos (Pred (Val Wrong)) = (Val Wrong)
    ssos (Succ (Val Wrong)) = (Val Wrong)
    ssos (IsZero (Val Wrong)) = (Val Wrong)
    ssos (Val (NValue Zero)) = (Val (NValue Zero))
    ssos (IfThenElse (Val Truthiness) a b) = a
    ssos (IfThenElse (Val Falsiness) a b) =  b
    ssos (IfThenElse (Val(NValue a)) b c) = (Val Wrong)
    ssos (IfThenElse q u v) = ssos (IfThenElse (ssos q) (ssos u) (ssos v))
    ssos (Succ (Val (NValue a))) = ssos (Val (NValue (NVSucc a)))
    ssos (Val (NValue (NVSucc a))) = (Val (NValue (NVSucc a)))
    ssos (Pred (Val (NValue Zero))) = (Val (NValue Zero))
    ssos (Pred (Val (NValue (NVSucc a)))) = ssos (Val (NValue a))
    ssos (Pred (Val a)) = (Val Wrong)
    ssos (Succ(Pred t)) = t
    ssos (Pred(Succ t)) = t
    ssos (Succ (Val a)) = (Val Wrong)
    ssos (Succ a) = Succ (ssos a)
    ssos (Pred a) = Pred (ssos a)
    --Get rid of successor extras, redundant
    ssos (IsZero (Val (NValue Zero)))= (Val Truthiness)
    ssos (IsZero (Val (NValue (NVSucc a)))) = (Val Falsiness)
    ssos (IsZero (Val a)) = (Val Wrong)
    ssos (IsZero (a)) = IsZero(ssos a)

    --ssos (IfThenElse ((Val Truthiness)) a b) = a
    --ssos (IfThenElse ((Val Falsiness)) a b) = b
    --ssos (IfThenElse x y z) = (IfThenElse x y z)

    --ssos (Pred (Succ t)) = t
    --ssos (Succ (Pred t)) = t

    eval:: T -> T
    eval a = 
        if a == (ssos a) then (a)
        else (eval (ssos a))
    
