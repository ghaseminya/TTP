/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic_ttp;

/**
 *
 * @author mnm
 */
public class new_main {

    public static void main(String as[]){

        Configuration conf=new Configuration();
        conf.getfromdatabase();
    }
}
/*
    // initialize GAL internal structures
    GaInitialize();

    // make chromosome parameters
    // crossover probability: 80%
    // crossover points: 2
    // no "improving only mutations"
    // mutation probability: 3%
    // number of moved classes per mutation: 2
    GaChromosomeParams chromosomeParams( 0.8F, 2, false, 0.03F, 2 );

    // instances of genetic operations
    ScheduleCrossover crossoverOperation;
    ScheduleMutation mutationOperation;
    ScheduleFitness fitnessOperation;

    // make CCB with fallowing setup:
    // there are no value set with ScheduleCrossover,
    // ScheduleMutation, ScheduleFitness genetic operations
    // set fittnes comparator for maximizing fitness value
    // use previously defined chromosome's parameters
    GaChromosomeDomainBlock<list<CourseClass*>> configBlock( NULL,
        &crossoverOperation, &mutationOperation, &fitnessOperation,
        GaFitnessComparatorCatalogue::Instance().GetEntryData(
        "GaMaxFitnessComparator" ),
        &chromosomeParams );

    // make prototype of chromosome
    Schedule prototype( &configBlock );

    // make population parameters
    // number of chromosomes in population: 100
    // population always has fixed number of chromosomes
    // population is not sorted
    // non-transformed(non-scaled) fitness values are used
    // for sorting and tracking chromosomes
    // population tracks 5 best and 5 worst chromosomes
    GaPopulationParameters populationParams( 100, false, false, false, 5, 5 );

    // make population parameters
    // number of chromosomes in population: 100
    // population always has fixed number of chromosomes
    // population is not sorted
    // non-transformed(non-scaled) fitness values are used
    // for sorting and tracking chromosomes
    // population tracks 5 best and 5 worst chromosomes
    GaPopulationParameters populationParams( 100, false, false, false, 5, 5 );

    // make parameters for selection operation
    // selection will choose 16 chromosomes
    // but only 8 best of them will be stored in selection result set
    // there will be no duplicates of chromosomes in result set
    GaSelectRandomBestParams selParam( 8, false, 16 );

    // make parameters for replacement operation
    // replace 8 chromosomes
    // but keep 5 best chromosomes in population
    GaReplaceElitismParams repParam( 8, 5 );

    // make parameters for coupling operation
    // coupling operation will produce 8 new chromosomes
    // from selected parents
    GaCouplingParams coupParam( 8 );

    // make population configuration
    // use defined population parameters
    // use same comparator for sorting as comparator used by chromosomes
    // use selection operation which randomly selects chromosomes
    // use replacement operation which randomly chooses chromosomes
    // from population which are going to be replaced,
    // but keeps best chromosomes
    // use simple coupling
    // disable scaling
    GaPopulationConfiguration populationConfig( populationParams,
        &configBlock.GetFitnessComparator(),
        GaSelectionCatalogue::Instance().GetEntryData( "GaSelectRandomBest" ),
        &selParam,
        GaReplacementCatalogue::Instance().GetEntryData( "GaReplaceRandom" ),
        &repParam,
        GaCouplingCatalogue::Instance().GetEntryData( "GaSimpleCoupling" ),
        &coupParam,
        NULL, NULL );

    // make population
    // with previously defined prototype of chromosomes
    // and population configuration
    GaPopulation population( &prototype, &populationConfig );

    // make parameters for genetic algorithms
    // algorithm will use two workers
    GaMultithreadingAlgorithmParams algorithmParams( 2 );
    // make incremental algorithm with previously defined
    // population and parameters
    GaIncrementalAlgorithm algorithm( &population, algorithmParams );

    // make parameters for stop criteria based on fitness value
    // stop when best chromosome reaches fitness value of 1
    GaFitnessCriteriaParams criteriaParams( 1, GFC_EQUALS_TO,
        GSV_BEST_FITNESS );

    // sets algorithm's stop criteria (base on fitness value)
    // and its parameters
    algorithm.SetStopCriteria(
        GaStopCriteriaCatalogue::Instance().GetEntryData(
        "GaFitnessCriteria" ),
        &criteriaParams );

    // make observer and subscribe it on algorithms events
    ScheduleObserver observer;
    algorithm.SubscribeObserver( &observer );

    // start execution
    algorithm.StartSolving( false );

    observer.WaitEvent();

    // free memory used by GAL internal structures
    GaFinalize();

    return 0;
    }
 * */

