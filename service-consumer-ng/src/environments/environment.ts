// This file can be replaced during build by using the `fileReplacements` array.
// `ng build` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

import {Environment} from './environment.model';

// run with "ng serve" in local IDE
// build with "ng b -c development"

export const environment: Environment = {
  productionMode: false,
  apiEndpoint: 'http://localhost:8081/api/v1',
  stage: 'local'
};
