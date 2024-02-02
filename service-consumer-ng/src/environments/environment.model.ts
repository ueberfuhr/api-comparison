import {InjectionToken} from '@angular/core';

/**
 * Type declaration for environment configuration.
 */
export interface Environment {
  /**
   * A flag indicating whether we run in production mode or not.
   */
  productionMode: boolean,
  /**
   * The stage where the application is deployed.
   */
  stage: Stage,
  /**
   * The URL to the backend.
   */
  apiEndpoint: string
}

/**
 * The kind of stages.
 */
export type Stage = 'local'; // extend here

/**
 * The injection token to get the API endpoint.
 * You can get it injected by using constructor parameter
 * <pre>
 *   @Inject(API_ENDPOINT) endpoint: string
 * </pre>
 */
export const API_ENDPOINT = new InjectionToken<string>('environment.apiEndpoint');
