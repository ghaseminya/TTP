/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic_ttp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author mnm
 */


public class Schedule implements Cloneable {
	public mnmrandom rand=new mnmrandom();
    Schedule newChromosome ;
     int DAY_HOURS =12;    // Number of working hours per day
     int DAYS_NUM=5;       // Number of days in week
     int _numberOfCrossoverPoints;
     // Number of classes that is moved randomly by single mutation operation
     int _mutationSize;
     // Probability that crossover will occure
     int _crossoverProbability;
     // Probability that mutation will occure
     int _mutationProbability;
     // Fitness value of chromosome
     float _fitness;
     public Configuration _conf;

    public float getFitness() {
        return _fitness;
    }
     // Flags of class requiroments satisfaction
     Vector<Boolean> _criteria;
     // Time-space slots, one entry represent one hour in one classroom
     Vector<List<CourseClass>> _slots;
     // Class table for chromosome
     // Used to determine first time-space slot used by class
     public Map<CourseClass, Integer> _classes=new HashMap<CourseClass, Integer>();
     public Schedule(Schedule c, boolean setupOnly,Configuration conf) {
         _conf=conf;
        // Copy constructor
	if( !setupOnly )
	{
            // copy code
            _slots = c._slots;
            _classes = c._classes;
            // copy flags of class requirements
            _criteria = c._criteria;
            // copy fitness
            _fitness = c._fitness;
            ////System.out.println("Schedule(Schedule c, boolean setupOnly,Configuration conf) : true");
        }
        else
	{
             ////System.out.println("Schedule(Schedule c, boolean setupOnly,Configuration conf) : false" );
             // reserve space for time-space slots in chromosomes code
             //            conf=new Configuration();
             //            conf.getfromdatabase();
        	//System.out.println();
             _slots=new Vector<List<CourseClass>>();//DAYS_NUM * DAY_HOURS * _conf.getNumberOfRoom()
             _slots.setSize( DAYS_NUM * DAY_HOURS * _conf.getNumberOfRoom());
             for (int i = 0; i < _slots.size(); i++) {
     			_slots.set(i, new ArrayList<CourseClass>());
     		}
             
             // reserve space for flags of class requirements
             _criteria=new Vector<Boolean>();//_conf.getNumberOfCourseclass() * 5
             _criteria.setSize(_conf.getNumberOfCourseclass() * 5 );
	}

	// copy parameters
	_numberOfCrossoverPoints = c._numberOfCrossoverPoints;
	_mutationSize = c._mutationSize;
	_crossoverProbability = c._crossoverProbability;
	_mutationProbability = c._mutationProbability;
}

    public Schedule(int numberOfCrossoverPoints, int mutationSize,int crossoverProbability, int mutationProbability ,Configuration conf) {
        // Initializes chromosomes with configuration block (setup of chromosome)
        _mutationSize=mutationSize;
        _numberOfCrossoverPoints=numberOfCrossoverPoints;
        _crossoverProbability=crossoverProbability;
        _mutationProbability=mutationProbability;
        _fitness=0;
        // reserve space for time-space slots in chromosomes code
//        conf=new Configuration();
        _conf=conf;
        ////System.out.println("conf.getNumberOfRoom()"+_conf.getNumberOfRoom());
        _slots=new Vector<List<CourseClass>>();//DAYS_NUM * DAY_HOURS * _conf.getNumberOfRoom()
        _slots.setSize( DAYS_NUM * DAY_HOURS * _conf.getNumberOfRoom() );
        for (int i = 0; i < _slots.size(); i++) {
			_slots.set(i, new ArrayList<CourseClass>());
		}
        
	// reserve space for flags of class requirements
        _criteria=new Vector<Boolean>();//_conf.getNumberOfCourseclass()* 5
	_criteria.setSize(_conf.getNumberOfCourseclass()* 5);
    }
    public Schedule MakeCopy(boolean setupOnly)
    {
        // make object by calling copy constructor and return smart pointer to new object
	return new Schedule( this, setupOnly,_conf );
    }
    // Makes new chromosome with same setup but with randomly chosen code
    public Schedule MakeNewFromPrototype()
    {
        
	 Schedule mnmnewChromosome = new Schedule( this, true,_conf );
	
     List<CourseClass> c =_conf.getCourseClasses();
	for( int it = 0; it != c.size(); it++ )// place classes at random position
	{
		// determine random position of class
		int nr =_conf.getNumberOfRoom();
		int dur = c.get(it).getDuration();
		int day =  rand.rand(0, DAYS_NUM);
		int room = rand.rand( 0, nr);
		int time = rand.rand(0,( DAY_HOURS + 1 - dur ));
                day=Math.abs(day);
                dur=Math.abs(dur);
                room=Math.abs(room);
		int pos = day * nr * DAY_HOURS+ room * DAY_HOURS + time;//this number is wrong and must be correct to day*room*time// + room * DAY_HOURS + time
		int maxpos=DAYS_NUM * nr * DAY_HOURS+ nr * DAY_HOURS +  (DAY_HOURS + 1 - dur) ;
		int minpos=0 * nr * DAY_HOURS+ 0 * DAY_HOURS + 0;
		System.out.println("\tmaxpos "+maxpos+"\tpos"+pos +"\tminpos"+minpos);
        pos =Math.abs(pos);
		for (int i = dur - 1; i >= 0; i--) {
			System.out.print(pos+" pos ");
				mnmnewChromosome._slots.get(pos + i).add(c.get(it));// c.get(it)
			}
 		mnmnewChromosome._classes.put(c.get(it) , pos );
	}
	this.CalculateFitness(mnmnewChromosome);
	System.out.println("new make from prototype");
	for (int i = 0; i < mnmnewChromosome._slots.size(); i++) {
		System.out.print(mnmnewChromosome._slots.get(i).size()+" ");
	}
	return mnmnewChromosome;
}

// Performes crossover operation using to chromosomes and returns pointer to offspring
public Schedule Crossover(Schedule parent2)
{
//    JOptionPane.showMessageDialog(null,_crossoverProbability+": WHY? :","asd", 0);

	// check probability of crossover operation
	if( rand.rand(0,  100) > this._crossoverProbability )
		// no crossover, just copy first parent
		return new Schedule( this, false ,_conf);

	// new chromosome object, copy chromosome setup
	Schedule n = new Schedule( this, true,_conf );
	//System.out.println("cross^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^"+n._classes.size());
	// number of classes
	int size = (int)this._classes.size();

	Vector<Boolean> cp=new Vector<Boolean>();
        cp.setSize(size);
        for(int i=0;i<size;i++){
            cp.remove(i);
            cp.add(i, Boolean.FALSE);
        }
	// determine crossover point (randomly)
	for( int i = _numberOfCrossoverPoints; i > 0; i-- )
	{
		while(true)
		{
			int p =rand.rand(0,  size);
			if( !cp.elementAt(p) )
			{
                            cp.remove(p);
				cp.insertElementAt(true,p);
				break;
			}
		}
	}

        Set< CourseClass > keys = _classes.keySet(); // get keys
        Set< CourseClass > keys2 = parent2._classes.keySet(); // get keys

        Iterator iter1 = _classes.entrySet().iterator();// = _classes.begin();
        
        Iterator iter2 = parent2._classes.entrySet().iterator();// parent2._classes.begin();

        
	// make new code by combining parent codes
	boolean first = new Random().nextInt() % 2 == 0;
	int key1=0;
        for( int i = 0; i < size; i++ )
        {
        	Map.Entry entry1= (Map.Entry) iter1.next();
        	Map.Entry entry2= (Map.Entry) iter2.next();
        	key1=n._classes.size();
            if( first )
		{
            	CourseClass t=(CourseClass)entry1.getKey();
			// insert class from first parent into new chromosome's calss table
			n._classes.put( t,(Integer)entry1.getValue() );
			if(n._classes.size()==key1){return null;}
			
			//System.out.println("1>"+t._name+" \t"+(Integer)entry1.getValue());
			// all time-space slots of class are copied
                        
                        
			for( int is = t.getDuration() - 1; is >= 0; is-- ){
                            n._slots.get((Integer)entry1.getValue()+is).add(t);
                        }
				
		}
		else
		{
			// insert class from second parent into new chromosome's calss table
			CourseClass t=(CourseClass)entry2.getKey();
			n._classes.put( t,(Integer)entry2.getValue() );
            if(n._classes.size()==key1){return null;}
			// all time-space slots of class are copied
			for( int is = t.getDuration() - 1; is >= 0; is-- )
                        {
                         
                            int stemp=(Integer)entry2.getValue();
                            n._slots.get(stemp+is).add(t);

                        }
		}
		// crossover point
		if( cp.get(i) )
			// change soruce chromosome
			first = !first;
		

        }
	n.CalculateFitness(this);
	System.out.println("new make from cross over");
	for (int i = 0; i < n._slots.size(); i++) {
		System.out.print(n._slots.get(i).size()+" ");
	}
	return n;
}

// Performs mutation on chromosome
public void Mutation()
{

	// check probability of mutation operation
	if( rand.rand(0, 100) > _mutationProbability )
		return;

	// number of classes
	int numberOfClasses = (int)_classes.size();
	// number of time-space slots
	int size = (int)_slots.size();

	// move selected number of classes at random position
	for( int i = _mutationSize; i > 0; i-- )
	{
		// select ranom chromosome for movement
		int mpos = rand.rand(0,numberOfClasses);
		int pos1 = 0;
                Iterator iter1 = _classes.entrySet().iterator();// = _classes.begin();
                Map.Entry entry1=(Map.Entry) iter1.next();
//		hash_map<CourseClass*, int>::iterator it = _classes.begin();
                for( ; mpos > 0; mpos-- )
                     entry1= (Map.Entry) iter1.next();

		// current time-space slot used by class
		pos1 = (Integer)entry1.getValue();

		CourseClass cc1 = (CourseClass)entry1.getKey();

		// determine position of class randomly
		int nr =_conf.getNumberOfRoom();
		int dur = cc1.getDuration();
		int day = rand.rand(0, DAYS_NUM);
		int room = rand.rand(0, nr);
		int time = rand.rand(0,( DAY_HOURS + 1 - dur ));
                nr=Math.abs(nr);
                day=Math.abs(day);
		int pos2 = day * nr * DAY_HOURS ;//+ room * DAY_HOURS + time

		// move all time-space slots
                //is is two i;

		for( int is = dur - 1; is >= 0; is-- )
		{
			// remove class hour from current time-space slot
			List<CourseClass> cl = _slots.get(pos1 + is);
            for(int it0=0;it0<cl.size();it0++) {
                if( cl.get(it0)== cc1 )
				{
					cl.remove(it0);
					break;
				}
			}
			// move class hour to new time-space slot
			_slots.get( pos2 + i ).add( cc1 );
		}

		// change entry of class table to point to new time-space slots
		if(_classes.containsKey(cc1))
                    {
                    ////System.out.println("go yo loop");
                              _classes.remove(cc1);
                              _classes.put(cc1,pos2);
                    }
                }
	System.out.println("new make from mutation");
	for (int i = 0; i < this._slots.size(); i++) {
		System.out.print(this._slots.get(i).size()+" ");
	}
	CalculateFitness(this);
}

// Calculates fitness value of chromosome
public void CalculateFitness(Schedule newChrom)
{
	// chromosome's score


	int score = 0;
int scoreroom=0;
int scorprof=0;
int scorga=0;
	int numberOfRooms =newChrom._conf.getNumberOfRoom();
	int daySize = newChrom.DAY_HOURS * numberOfRooms;
	int ci = 0;
	// check criterias and calculate scores for each class in schedule
        Set<CourseClass> set=newChrom._classes.keySet();
        for(CourseClass ity:set){
            
            // coordinate of time-space slot
            int p=newChrom._classes.get(ity);
//            if(p<0){
////                JOptionPane.showMessageDialog(null,p+": WHY? :","asd", 0);
//                continue;}
            int day = p / daySize;
            int time = p % daySize;
            int room = time / newChrom.DAY_HOURS;
            time = time % newChrom.DAY_HOURS;
            CourseClass temp=ity;
            int dur =temp.getDuration();
            // check for room overlapping of classes
            boolean ro = false;


            for( int i = dur - 1; i >= 0; i-- )
            {
                if(newChrom. _slots.get( p + i ).size() > 1 )
			{
                System.out.println("----------------------------------------------------------------");
				ro = true;
				break;
			}
     	    }
            // on room overlaping
            if( !ro ){
                score++;scoreroom++;
            }
            newChrom._criteria.insertElementAt(!ro,ci);
            //System.out.println("newChrom._criteria.size()"+newChrom._criteria.size());
            CourseClass cc = ity;
//            conf=new Configuration();
            Room r = newChrom._conf.GetRoomById( room );
            ////System.out.println( r.getNumberOfSeats()+"this is ()()()()()()"+ cc.getNumberOfSeats());// does current room have enough seats

            newChrom._criteria.insertElementAt( r.getNumberOfSeats()>= cc.getNumberOfSeats(), ci + 1 );
            if(newChrom. _criteria.get(ci + 1))
                score++;score++;
            
            boolean po = false, go = false,key=false;;
            // check overlapping of classes for professors and student groups
            total_overlap:
            for( int i = numberOfRooms, t = day * daySize + time; i > 0; i--, t += newChrom.DAY_HOURS )
            {
            	if(key){break;}
                // for each hour of class
                for( int is = dur - 1; is >= 0; is-- )
                {
                    // check for overlapping with other classes at same time
                 
//                    //System.out.println(day+"day"+ daySize+" daySize"+"tie" + time);
                    List<CourseClass> cl = newChrom._slots.get(t + is);

                    for(CourseClass te:cl){
//                        //System.out.println(te._professor._name+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+cl.size());
                        if( cc != te )

                            // professor overlaps?

                            ////System.out.println(temps._professor._name);
                            ////System.out.println(cc._professor._name);
                            ////System.out.println(cc.ProfessorOverlaps(iter2.next()));
                            if( !po && cc.ProfessorOverlaps(te ) )
                                po = true;
                            // student group overlaps?
                            if( !go && cc.GroupsOverlap(te ) )
                                go = true;
                            // both type of overlapping? no need to check more
                            if( po && go )
                                {key=true;break total_overlap;}
                            }
                }
                    

}


		// professors have no overlaping classes?
		if( !po){//
			score++;scorprof++;}
		newChrom._criteria.insertElementAt(!po,ci + 2);

		// student groups has no overlaping classes?
		if( !go){//
			score++;scorga++;}
		newChrom._criteria.insertElementAt( !go, ci + 3);
//              if(ro||go||po)

		ci += 4;
	}//go+"/"+po+"/"+ro+"/"
//JOptionPane.showMessageDialog(null,_criteria.elementAt(ci-1)+"critatria"+_criteria.elementAt(ci)+_criteria.elementAt(ci+1)+_criteria.elementAt(ci+2)+_criteria.elementAt(ci+3),"asdasd",0);
	// calculate fitess value based on score
        
	newChrom._fitness = (float)score / (newChrom._conf.getNumberOfCourseclass() * 4);
//    //System.out.println("fit nets:"+newChrom._fitness+"room:"+scoreroom+"ga"+scorga+"prof"+scorprof);
}



public void showchromozom(Schedule sch  ){
    
	String res[][]=new String[5][12];
    Vector<String[][]> result=new Vector<String[][]>();
    result.setSize(sch._conf.getNumberOfRoom());//a vector of room that include proram of room
    Set<CourseClass> maps=sch._classes.keySet();
    int daySize = sch.DAY_HOURS *sch._conf.getNumberOfRoom();
    sch._conf.getfromdatabase();
    System.out.println(sch._fitness+"day size"+maps.size() +" : ");
    for(int i=0;i<sch._conf.getNumberOfRoom();i++)
    {
        result.remove(i);
        res=new String[5][12];
        result.add(i,res);
    }

    for(CourseClass cors:maps){
        int pos=(int)sch._classes.get(cors);
        int row=0;
        int col=0;
        int roomnum=0;
        int day = pos / daySize;
            int time = pos % daySize;
            int room = time / sch.DAY_HOURS;
            time = time % sch.DAY_HOURS;
            day=Math.abs(day);
                room=Math.abs(room);
            time=Math.abs(time);
            if(sch._slots.get(pos).size()>1)
                System.out.println("????????????????"+sch._slots.get(pos).size());
//                for (int i = 0; i < sch._slots.get(pos).size(); i++) {
//                	System.out.print("this is slot value:\t"+sch._slots.get(pos).get(i)._name);
				
//				}
                
            
                result.get(room)[day][time]=cors._name;
            System.out.println(pos+"/"+daySize+"/"+time+"********************"+day);
//            result.remove(room);
//         result.add(room, res);
    }
    for(int i=0;i<result.size();i++)
    {
        
        System.out.println("\n\n\n\n\n\tnew room :"+i);
     System.out.println("SAT\t\tSUN\t\tMON\t\tTUS\t\tWED\t\tTHU\t\tFRI");
        for(int j=0;j<12;j++)
        {
            for(int k=0;k<5;k++){
                System.out.printf("%-19s",result.get(i)[k][j]);
         }
         System.out.println();
        }

    }



 System.out.println(" ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
}
}

enum AlgorithmState {
    AS_USER_STOPED,
    AS_CRITERIA_STOPPED,
    AS_RUNNING
}
class Algorithm{
Vector<Schedule> _chromosomes;
mnmrandom rand=new mnmrandom();
	// Inidicates wheahter chromosome belongs to best chromosome group
	Vector<Boolean> _bestFlags;

	// Indices of best chromosomes
	Vector<Integer> _bestChromosomes;

	// Number of best chromosomes currently saved in best chromosome group
	int _currentBestSize;

	// Number of chromosomes which are replaced in each generation by offspring
	public int _replaceByGeneration;


	// Prototype of chromosomes in population
	public Schedule _prototype;

	// Current generation
	int _currentGeneration;

	// State of execution of algorithm
	AlgorithmState _state;

	// Synchronization of algorithm's state
//	CCriticalSection _stateSect;

	// Pointer to global instance of algorithm
	static Algorithm _instance;
        Configuration _conf;

    public Algorithm() {
        
    }

	// Synchronization of creation and destruction of global instance
//	static CCriticalSection _instanceSect;

        // Pointer to global instance of algorithm

// Synchronization of creation and destruction of global instance
//CCriticalSection Algorithm::_instanceSect;

// Returns reference to global instance of algorithm
        
public Algorithm fetchalg(Configuration conf)
{
//	CSingleLock lock( &_instanceSect, TRUE );
_conf=conf;
	// global instance doesn't exist?
	if( _instance == null )
	{
		// set seed for random generator
//		srand( GetTickCount() );

		// make prototype of chromosomes
		

                

		// make new global instance of algorithm using chromosome prototype
//		_instance = new Algorithm( 5, 8, 5, prototype);
                
	}
////System.out.println("_instance._replaceByGeneration"+_instance._replaceByGeneration);
	return _instance;
}

// Frees memory used by gloval instance
public void FreeInstance()
{
//	CSingleLock lock( _instanceSect, true );

	// free memory used by global instance if it exists
//	if( _instance != null )
//	{
//		delete _instance._prototype;
//		delete _instance->_observer;
//		delete _instance;
//
//		_instance = NULL;
//	}
}

// Initializes genetic algorithm
public Algorithm(int numberOfChromosomes, int replaceByGeneration, int trackBest,Schedule prototype){
     this._replaceByGeneration=replaceByGeneration;
     //System.out.println(replaceByGeneration+"_instance._replaceByGeneration"+this._replaceByGeneration);
     this._currentBestSize=0;
     this._prototype=prototype;
     this._currentGeneration=0;
     this._state=AlgorithmState.AS_USER_STOPED;

	// there should be at least 2 chromosomes in population
	if( numberOfChromosomes < 2 )
		numberOfChromosomes = 2;

	// and algorithm should track at least on of best chromosomes
	if( trackBest < 1 )
		trackBest = 1;

	if( this._replaceByGeneration < 1 )
		this._replaceByGeneration = 1;
	else if( this._replaceByGeneration > numberOfChromosomes - trackBest )
		this._replaceByGeneration = numberOfChromosomes - trackBest;

	// reserve space for population
	this._chromosomes=new Vector<Schedule>(numberOfChromosomes);
	this._chromosomes.setSize(numberOfChromosomes);
	this._bestFlags=new Vector<Boolean>(numberOfChromosomes);
	this._bestFlags.setSize( numberOfChromosomes );

	// reserve space for best chromosome group
	this._bestChromosomes=new Vector<Integer>(trackBest);
	this._bestChromosomes.setSize( trackBest );

	// clear population
	for( int i = (int)this._chromosomes.size() - 1; i >= 0; --i )
	{
		this._bestFlags.remove(i);

		this._bestFlags.add(i,false);
	}
	//System.out.println(replaceByGeneration+"_instance._replaceByGeneration"+this._replaceByGeneration);
//
     ////System.out.println("chroozom :::; "+_chromosomes.size()+" /"+numberOfChromosomes);
}


public Schedule Start()
{
//    _replaceByGeneration=8;
    //System.out.println(this._replaceByGeneration+"prototype"+this._chromosomes.size());

    if( _prototype.equals(null) )
        {
            ////System.out.println("@@@@@ptroto is null");
		return null;
        }

//	CSingleLock lock( _stateSect, true );

	// do not run already running algorithm
	if( _state == AlgorithmState.AS_RUNNING )
        {
            ////System.out.println("@@@@@stat is null");
            return null;
        }
		

	_state = AlgorithmState.AS_RUNNING;

//	lock.Unlock();


	// clear best chromosome group from previous execution
	ClearBest();

	// initialize new population with chromosomes randomly built using prototype
	int i = 0;

//        int number=;
	for( int it=0;it<_chromosomes.size(); ++it,++i  )
	{
        _chromosomes.remove(it);
		_chromosomes.add(it,this._prototype.MakeNewFromPrototype());
    	AddToBest( i );
	}
	_currentGeneration = 0;
	while(true )
	{
//		lock.Lock();

		// user has stopped execution?
		if( _state != AlgorithmState.AS_RUNNING )
		{
//			lock.Unlock();
			break;
		}
////System.out.println("Schedule best = GetBestChromosome(); "+_bestChromosomes.get(0));
		Schedule best = GetBestChromosome();

		// algorithm has reached criteria?
		if( best.getFitness() >= .5 )
		{
			_state = AlgorithmState.AS_CRITERIA_STOPPED;
//			lock.Unlock();
			break;
		}

//		lock.Unlock();

		// produce offepsing
		Vector<Schedule> offspring=new Vector<Schedule>();
		offspring.setSize( _replaceByGeneration );
                for (int k = 0; k < _chromosomes.size(); k++) {
    				//System.out.println("_chromosomes.get(k)._fitness"+_chromosomes.get(k)._classes.size());
    			}

		for( int j = 0; j <_replaceByGeneration; j++ )
		{
			// selects parent randomly
                    //////System.out.println("new Random().nextInt() % _chromosomes.size()"+new Random().nextInt() % _chromosomes.size());
			int rand1=rand.rand(0, _chromosomes.size());
			int rand2=rand.rand(0, _chromosomes.size());
			Schedule p1 = _chromosomes.get( rand1);
			Schedule p2 = (Schedule)_chromosomes.get(rand2);
			
			for (int k = 0; k < _chromosomes.size(); k++) {
				//System.out.println(_chromosomes.get(k)._fitness);
			}

			//System.out.println(rand2+"\tp2._classes.size()"+p2._classes.size()+"size"+_chromosomes.size());
			Schedule temp=null;
			do{
				temp=p1.Crossover( p2 );
				//System.out.print(temp);
			}while(temp==null);
			offspring.insertElementAt(temp ,j);//
			offspring.get(j).Mutation();
		}

		// replace chromosomes of current operation with offspring
		for( int j = 0; j < _replaceByGeneration; j++ )
		{
			int ci=0;
			
			do
			{
				// select chromosome for replacement randomly
				ci = Math.abs(new Random().nextInt() )% (int)_chromosomes.size();
////System.out.println(this._bestFlags.size()+"this is the best chromosom number :"+ci+" : ");
				// protect best chromosomes from replacement
			} while( IsInBest( ci ) );

			// replace chromosomes
//			delete _chromosomes[ ci ];
			
			_chromosomes.remove(ci);
			_chromosomes.insertElementAt( offspring.get(j),ci);
			
			// try to add new chromosomes in best chromosome group
			AddToBest( ci );
		}


		_currentGeneration++;
                ////System.out.println(_currentGeneration+"this is generic fit>>>>>>>>>"+GetBestChromosome()._fitness);
                //showchromozom(_chromosomes);
                //////System.out.println(_currentGeneration+"this is generic fit>>>>>>>>>"+GetBestChromosome()._fitness);
	}
GetBestChromosome().showchromozom(GetBestChromosome());
//        showchromozom(GetBestChromosome());
	
        return GetBestChromosome();
}

// Stops execution of algoruthm
public void Stop()
{
//	CSingleLock lock( _stateSect, true );

	if( _state == AlgorithmState.AS_RUNNING )
		_state = AlgorithmState.AS_USER_STOPED;

//	lock.Unlock();
}

// Returns pointer to best chromosomes in population
public Schedule GetBestChromosome()
{
//    for(int i=0;i<_bestChromosomes.size();i++)
           ////System.out.println(_chromosomes.get(_bestChromosomes.get(i))._fitness+"_chromosomes.size() ins GetBestChromosome: "+_bestChromosomes.get(i));
//	for(int i=0;i<_bestChromosomes.size();i++)
        ////System.out.println("_chromosomes.size() ins get best glag: "+_bestFlags.get(i));
	return _chromosomes.get(_bestChromosomes.get(0 ));
}

// Tries to add chromosomes in best chromosome group
public void AddToBest(int chromosomeIndex)
{
	// don't add if new chromosome hasn't fitness big enough for best chromosome group
	// or it is already in the group?
	if( ( _currentBestSize == (int)_bestChromosomes.size() &&
		_chromosomes.get(_bestChromosomes.get(_currentBestSize - 1 )).getFitness() >=
		_chromosomes.get(chromosomeIndex).getFitness() ) || _bestFlags.get(chromosomeIndex ) )
		return;

	// find place for new chromosome
	int i = _currentBestSize;
	for( ; i > 0; i-- )
	{
		// group is not full?
		if( i < (int)_bestChromosomes.size() )
		{
			// position of new chromosomes is found?
                    //////System.out.println(_bestChromosomes.get(i - 1 )+"<>"+chromosomeIndex+"_chromosomes.get( _bestChromosomes.get(i - 1 )).getFitness()"+_chromosomes.get( _bestChromosomes.get(i - 1 )).getFitness());
                    //////System.out.println("_chromosomes.get(chromosomeIndex ).getFitness()"+_chromosomes.get(chromosomeIndex ).getFitness());
			if( _chromosomes.get( _bestChromosomes.get(i - 1 )).getFitness() >
				_chromosomes.get(chromosomeIndex ).getFitness() )
				break;

			// move chromosomes to make room for new
			_bestChromosomes.remove(i);
			_bestChromosomes.insertElementAt( _bestChromosomes.get( i - 1 ),i);
		}
		else
			// group is full remove worst chromosomes in the group
                {
                    //////System.out.println(  _bestChromosomes.get(i - 1 )+"$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$4");
                    	_bestFlags.remove(chromosomeIndex);
                    _bestFlags.insertElementAt(false, _bestChromosomes.get(i - 1 ));
                }
	}

	// store chromosome in best chromosome group
        ////////System.out.println("chromosomeIndex,i"+chromosomeIndex+" : "+i);
//        JOptionPane.showMessageDialog(null,chromosomeIndex+"/"+i,"asdasd",0);
	_bestChromosomes.remove(i);
        _bestChromosomes.insertElementAt(chromosomeIndex,i);
        //////System.out.println(  chromosomeIndex+"$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$"+_bestFlags.size());
	_bestFlags.remove(chromosomeIndex);
        _bestFlags.insertElementAt( true,chromosomeIndex);

	// increase current size if it has not reached the limit yet
	if( _currentBestSize < (int)_bestChromosomes.size() )
		_currentBestSize++;
}

// Returns TRUE if chromosome belongs to best chromosome group
public boolean IsInBest(int chromosomeIndex)
{
//    for(int i=0;i<_bestFlags.size();i++)
//        //////System.out.println(_bestFlags.get(i)+"this is bestflag");
	return _bestFlags.get(chromosomeIndex) ;
}

// Clears best chromosome group
public void ClearBest()
{
	for( int i = (int)_bestFlags.size() - 1; i >= 0; --i )
        {
            _bestFlags.remove(i);
            _bestFlags.insertElementAt(false,i);
        }
		

	_currentBestSize = 0;
}
public void showchromozom2s(Schedule sch){
    String res[][]=new String[7][3];
    Vector<String[][]> result=new Vector<String[][]>();
     ////System.out.println(sch.newChromosome._fitness +" : ");
    sch.newChromosome._conf=new Configuration();
    sch.newChromosome._conf.getfromdatabase();
    result.setSize(sch.newChromosome._conf.getNumberOfRoom());//a vector of room that include proram of room
    Set<CourseClass> maps=sch.newChromosome._classes.keySet();
    int daySize = sch.newChromosome.DAY_HOURS *sch.newChromosome._conf.getNumberOfRoom();
    sch.newChromosome._conf.getfromdatabase();
    ////System.out.println(daySize+"day size"+sch.newChromosome._conf.getNumberOfRoom() +" : ");
    for(int i=0;i<10;i++)
    {
        result.remove(i);
        res=new String[7][3];
        result.add(i,res);
    }

    for(CourseClass cors:maps){
        int pos=(int)sch.newChromosome._classes.get(cors);
        int row=0;
        int col=0;
        int roomnum=0;
        int day = pos / daySize;
            int time = pos % daySize;
            int room = time / sch.newChromosome.DAY_HOURS;
            time = time % sch.newChromosome.DAY_HOURS;
            day=Math.abs(day);
                room=Math.abs(room);
            day=Math.abs(day);
            time=Math.abs(time);



            result.get(room)[day][time]=cors._name;
            ////System.out.println(room+"********************"+result.size());
//            result.remove(room);
//         result.add(room, res);
    }
    for(int i=0;i<result.size();i++)
    {
        try{
            ////System.out.print("");
        }catch(NullPointerException sa){continue;}
        ////System.out.println("\n\n\n\n\n\tnew room :"+i);
     ////System.out.println("SAT\t\tSUN\t\tMON\t\tTUS\t\tWED\t\tTHU\t\tFRI");
        for(int j=0;j<3;j++)
        {
            for(int k=0;k<7;k++){
                ////System.out.printf("%-19s",result.get(i)[k][j]);
         }
         //System.out.println();
        }

    }



 //System.out.println(" ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
}
}

